package com.vaibhav.movielistingapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.IOException
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path as Path1

class LORApi() {
    companion object{
        private val url : String = "https://the-one-api.dev/v2/"
        private var token = "W7d9yyxAij0cItOgRC3n"
        private var lorCalls : LorCalls? = null;
        private var retrofit : Retrofit? = null

        private var client: OkHttpClient = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                return chain.proceed(newRequest)
            }
        }).build()

        fun getService() : LorCalls{
            if(lorCalls == null){
                retrofit = Retrofit.Builder()
                            .client(client)
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                lorCalls = retrofit!!.create(LorCalls::class.java)
            }
            return lorCalls!!
        }
    }
    interface  LorCalls {
        @GET("movie")
        fun getMovies(): Call<MovieResponse>

        @GET("movie/{id}")
        fun getMovieById(@Path1("id") id : String) : Call<MovieResponse>
    }}