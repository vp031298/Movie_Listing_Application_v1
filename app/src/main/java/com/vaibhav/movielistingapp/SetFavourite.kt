package com.vaibhav.movielistingapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourites")
data class SetFavourite(
                @PrimaryKey
                val id : String,
                val name : String)