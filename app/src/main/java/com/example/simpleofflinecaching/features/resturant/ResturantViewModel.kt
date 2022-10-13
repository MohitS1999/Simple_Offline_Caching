package com.example.simpleofflinecaching.features.resturant


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleofflinecaching.api.ResturantApi
import com.example.simpleofflinecaching.data.Resturant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResturantViewModel @Inject constructor(
    api: ResturantApi
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Resturant>>()
    val restaurants: LiveData<List<Resturant>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurant()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }

}