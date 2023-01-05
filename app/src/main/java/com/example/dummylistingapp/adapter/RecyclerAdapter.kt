package com.example.dummylistingapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.R
import com.example.dummylistingapp.model.Item
import com.squareup.picasso.Picasso

class RecyclerAdapter(var context: Context, val itemList: ArrayList<Item>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
        val itemTitle: TextView
        val itemSubtitle: TextView
        val itemImg: ImageView
        val itemDesc: TextView

        init {
            itemTitle = v.findViewById(R.id.item_title)
            itemSubtitle = v.findViewById(R.id.item_subtitle)
            itemImg = v.findViewById(R.id.item_image)
            itemDesc = v.findViewById(R.id.item_desc)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newList = itemList[position]
        holder.itemTitle.text = newList.itemTitle
        holder.itemSubtitle.text = newList.itemSubtitle
        Picasso.get().load(newList.itemImg).into(holder.itemImg);
        holder.itemDesc.text = newList.itemDesc
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}