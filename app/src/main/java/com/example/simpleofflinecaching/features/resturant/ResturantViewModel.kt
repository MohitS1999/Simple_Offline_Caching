package com.example.simpleofflinecaching.features.resturant


import androidx.lifecycle.*
import com.example.simpleofflinecaching.api.ResturantApi
import com.example.simpleofflinecaching.data.Resturant
import com.example.simpleofflinecaching.data.ResturantRepositry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResturantViewModel @Inject constructor(
   repositry: ResturantRepositry
) : ViewModel() {
    // caching
    val restaurants = repositry.getRestaurants().asLiveData()

   /* private val restaurantsLiveData = MutableLiveData<List<Resturant>>()
    val restaurants: LiveData<List<Resturant>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurant()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }*/

}