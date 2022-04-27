package com.vaibhav.movielistingapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.RoomMasterTable

@Database(entities = [SetFavourite::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun setFavouriteDao(): SetFavouriteDao

    companion object {
        private var INSTANCE: FavouriteDatabase? = null
        fun getDatabase(context: Context): FavouriteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        FavouriteDatabase::class.java,
                        "favourtie_database"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}