package com.vaibhav.movielistingapp

import androidx.lifecycle.LiveData
import retrofit2.Call

class LorRepository( private val favouriteDao: SetFavouriteDao?) {

    private var lorApi: LORApi.LorCalls? = null
    constructor(lorApi2 : LORApi.LorCalls?, favouriteDao: SetFavouriteDao?) : this(favouriteDao){
        this.lorApi = lorApi2
    }

    fun getMovies() : Call<MovieResponse>{
        return lorApi!!.getMovies()
    }

    fun getMovieById(path : String) : Call<MovieResponse>{
        return lorApi!!.getMovieById(path)
    }

    fun getFavourites(): LiveData<List<SetFavourite>> {
        return favouriteDao!!.getFavourites()
    }

    suspend fun addToFavourites(setFavourite: SetFavourite) {
          favouriteDao!!.addToFavourites(setFavourite)
    }
}