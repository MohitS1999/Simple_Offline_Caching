package com.example.simpleofflinecaching.data

import androidx.room.withTransaction
import com.example.simpleofflinecaching.api.ResturantApi
import com.example.simpleofflinecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ResturantRepositry @Inject constructor(
    private val api: ResturantApi,
    private val db:ResturantDatabase
) {
    private val resturantDao = db.resturantDao()
    fun getRestaurants() = networkBoundResource(
        query = {
            resturantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurant()
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                resturantDao.deleteAllRestaurants()
                resturantDao.insertRestaurants(restaurants)
            }

        }
    )
}