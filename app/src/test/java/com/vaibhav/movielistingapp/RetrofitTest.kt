package com.vaibhav.movielistingapp

import okhttp3.OkHttpClient
import org.junit.Before
import org.junit.Test
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query


class RetrofitTest {

    fun remoteApi(baseUrl: String): RemoteApi {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl(baseUrl)
            .build()
            .create(RemoteApi::class.java)
    }

    interface RemoteApi {
        @GET("/api/data")
        fun searchByPhrase(@Query("search") searchPhrase: String): Call<MovieResponse>
    }
}