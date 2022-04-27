package com.vaibhav.movielistingapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call

class LorViewModelFactory(private val repository: LorRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LorViewModel(repository) as T
    }
}