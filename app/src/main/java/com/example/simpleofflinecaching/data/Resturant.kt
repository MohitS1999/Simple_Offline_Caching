package com.example.simpleofflinecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Resturant(
    @PrimaryKey val username: String,
    val gender: String,
    val avatar: String,
    val email: String
)