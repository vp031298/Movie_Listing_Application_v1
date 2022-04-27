package com.vaibhav.movielistingapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Delete

import androidx.room.Update

import androidx.room.OnConflictStrategy

@Dao
interface SetFavouriteDao {

    @Query("SELECT * FROM Favourites")
    fun getFavourites() : LiveData<List<SetFavourite>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavourites(setFavourite: SetFavourite)
}

