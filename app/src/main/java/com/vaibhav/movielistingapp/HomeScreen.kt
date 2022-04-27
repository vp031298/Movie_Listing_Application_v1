package com.vaibhav.movielistingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        var btnAllMovies : Button = findViewById(R.id.listAllMovies)
        var btnGetFav : Button = findViewById(R.id.getFavourites)

        btnAllMovies.setOnClickListener{
            var intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnGetFav.setOnClickListener{
            var intent : Intent = Intent(this, ListFavourites::class.java)
            startActivity(intent)
        }
    }
}