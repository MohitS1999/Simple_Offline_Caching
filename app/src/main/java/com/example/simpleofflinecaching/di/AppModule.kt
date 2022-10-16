package com.example.simpleofflinecaching.di

import android.app.Application
import androidx.room.Room
import com.example.simpleofflinecaching.api.ResturantApi
import com.example.simpleofflinecaching.data.ResturantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(ResturantApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides

    fun providesRestaurantApi(retrofit: Retrofit) : ResturantApi =
        retrofit.create(ResturantApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : ResturantDatabase =
        Room.databaseBuilder(app, ResturantDatabase::class.java, "restaurant_database")
            .build()

}