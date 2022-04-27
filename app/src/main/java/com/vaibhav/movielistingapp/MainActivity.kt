package com.vaibhav.movielistingapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var repositoryRoom : LorRepository? = null
    var repositoryRetrofit : LorRepository? = null
    var setFavouriteDao : SetFavouriteDao? = null
    lateinit var viewModelRetrofit: LorViewModel
    lateinit var viewModelRoom: LorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //roomSetup() //Seting up  Room Database

        //viewModelRoom.addToFavourites(setFavourite)

        retrofitSetup()
        getMovies()
        //getMovieById("5cd95395de30eff6ebccde57")
    }

    fun getMovies() {
        var result = viewModelRetrofit.getMovies()
        result.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                var movieResponse: MovieResponse? = response.body()
                Toast.makeText(this@MainActivity, "Response Successful", Toast.LENGTH_SHORT).show()

                var recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
                recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView!!.adapter = RecyclerViewAdapter(movieResponse!!,this@MainActivity)

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Response failure", Toast.LENGTH_SHORT).show()

            }

        })
    }

    fun getMovieById(id : String){
        var result = viewModelRetrofit.getMovieById(id)
        result.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                var movieResponse: MovieResponse? = response.body()
                Toast.makeText(this@MainActivity, "Response Successful", Toast.LENGTH_SHORT).show()

                var recyclerView: RecyclerView? = findViewById(R.id.recyclerView)
                recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
                recyclerView!!.adapter = RecyclerViewAdapter(movieResponse!!,this@MainActivity)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Response failure", Toast.LENGTH_SHORT).show()

            }

        })
    }


    fun roomSetup(){
        setFavouriteDao = FavouriteDatabase.getDatabase(applicationContext).setFavouriteDao()
        repositoryRoom = LorRepository(setFavouriteDao)
        viewModelRoom = ViewModelProvider(this,LorViewModelFactory(repositoryRoom!!)).get(LorViewModel::class.java)

    }

    fun retrofitSetup(){
        repositoryRetrofit = LorRepository(LORApi.getService(),null)
        viewModelRetrofit = ViewModelProvider(this, LorViewModelFactory(repositoryRetrofit!!)).get(LorViewModel::class.java)
    }
}