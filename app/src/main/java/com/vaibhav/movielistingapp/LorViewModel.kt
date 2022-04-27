package com.vaibhav.movielistingapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call

class LorViewModel(private val lorRepository: LorRepository) : ViewModel() {

    fun getMovies(): Call<MovieResponse> {
        return lorRepository.getMovies()
    }

    fun getMovieById(path : String) : Call<MovieResponse> {
        return lorRepository.getMovieById(path)
    }

    fun getFavourites() : LiveData<List<SetFavourite>>{
        return lorRepository.getFavourites()
    }

    fun addToFavourites(setFavourite: SetFavourite){
        viewModelScope.launch(Dispatchers.IO){
             lorRepository.addToFavourites(setFavourite)
        }

    }
}