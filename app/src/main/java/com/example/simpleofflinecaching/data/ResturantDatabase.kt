package com.example.simpleofflinecaching.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Resturant::class], version = 1)
abstract class ResturantDatabase : RoomDatabase(){

    abstract fun resturantDao(): ResturantDao
}