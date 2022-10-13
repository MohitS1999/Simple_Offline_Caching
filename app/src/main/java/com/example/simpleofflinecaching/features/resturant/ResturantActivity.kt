package com.example.simpleofflinecaching.features.resturant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleofflinecaching.R
import com.example.simpleofflinecaching.databinding.ActivityResturantBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResturantActivity : AppCompatActivity() {

    private val viewModel: ResturantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResturantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resturantAdapter = ResturantAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = resturantAdapter
                layoutManager = LinearLayoutManager(this@ResturantActivity)
            }

            viewModel.restaurants.observe(this@ResturantActivity){ restaurants ->
                resturantAdapter.submitList(restaurants)
            }
        }
    }
}
