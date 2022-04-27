package com.vaibhav.movielistingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class ListFavourites : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_favourites)

        var repositoryRoom : LorRepository? = null
        var setFavouriteDao : SetFavouriteDao? = null
        lateinit var viewModelRoom: LorViewModel

        setFavouriteDao = FavouriteDatabase.getDatabase(applicationContext).setFavouriteDao()
        repositoryRoom = LorRepository(setFavouriteDao)
        viewModelRoom = ViewModelProvider(this,LorViewModelFactory(repositoryRoom!!)).get(LorViewModel::class.java)

        var tvList : TextView = findViewById(R.id.textView)


        viewModelRoom.getFavourites().observe(this){
           var list : List<SetFavourite> = it
            tvList.setText(list.get(0).name)
        }
    }
}