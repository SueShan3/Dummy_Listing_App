package com.example.dummylistingapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.databinding.RatingListBinding
import com.example.dummylistingapp.model.Ratings

class RatingAdapter: RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    lateinit var ratingList: List<Ratings>

    class ViewHolder(val binding: RatingListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            RatingListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = ratingList[position]

        with(holder.binding) {
            itemSource.text = newList.source
            itemValue.text = newList.value
        }
    }

    override fun getItemCount(): Int {
        return ratingList.size
    }
}