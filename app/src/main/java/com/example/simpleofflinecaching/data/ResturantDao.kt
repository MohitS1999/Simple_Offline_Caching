package com.example.simpleofflinecaching.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ResturantDao {
    // for returning function we don't need the suspend
    @Query("Select * from restaurants")
    fun getAllRestaurants(): Flow<List<Resturant>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurants(resturant: List<Resturant>)

    @Query("Delete From restaurants")
    suspend fun deleteAllRestaurants()

}