package com.example.simpleofflinecaching.features.resturant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simpleofflinecaching.data.Resturant
import com.example.simpleofflinecaching.databinding.ResturantItemBinding

class ResturantAdapter : ListAdapter<Resturant,ResturantAdapter.ResturantViewHolder>(ResturantComparator()) {

    class ResturantViewHolder(private val binding: ResturantItemBinding) :
            RecyclerView.ViewHolder(binding.root){
                fun bind(resturant: Resturant){
                    binding.apply {
                        Glide.with(itemView)
                            .load(resturant.logo)
                            .into(imageViewLogo)

                        textViewName.text = resturant.name
                        textViewType.text = resturant.type
                        textViewType.text = resturant.address
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResturantViewHolder {
        val binding = ResturantItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ResturantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResturantViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }

    class ResturantComparator : DiffUtil.ItemCallback<Resturant>(){
        override fun areItemsTheSame(oldItem: Resturant, newItem: Resturant) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Resturant, newItem: Resturant) =
            oldItem == newItem

    }

}