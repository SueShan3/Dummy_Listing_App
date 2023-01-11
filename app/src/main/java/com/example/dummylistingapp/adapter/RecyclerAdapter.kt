package com.example.dummylistingapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.databinding.ItemListBinding
import com.example.dummylistingapp.model.Item
import com.squareup.picasso.Picasso

class RecyclerAdapter(
    private var itemList: ArrayList<Item>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)

    // An interface that specifies listener’s behaviour.
    // OnItemClickListener used for going to a particular activity when a particular row is touched.
    interface OnItemClickListener {
        fun onItemClick(item: Item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding =
            ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = itemList[position]

        with(holder.binding) {
            itemTitle.text = newList.itemTitle
            itemSubtitle.text = newList.itemSubtitle
            Picasso.get().load(newList.itemImg).into(itemImage)
            itemDesc.text = newList.itemDesc

            root.setOnClickListener {
                listener.onItemClick(newList)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterList(filteredList: ArrayList<Item>) {
        itemList = filteredList
        //Update adapter
        notifyDataSetChanged()
    }
}