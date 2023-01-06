package com.example.dummylistingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.dummylistingapp.model.Item
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var itemModel: Item? = null
        itemModel = arguments?.getParcelable("item")

        val itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemSubtitle = view.findViewById<TextView>(R.id.item_subtitle)
        val itemImg = view.findViewById<ImageView>(R.id.item_image)
        val itemDesc = view.findViewById<TextView>(R.id.item_desc)

        itemTitle.text = itemModel?.itemTitle.toString()
        itemSubtitle.text = itemModel?.itemSubtitle.toString()
        Picasso.get().load(itemModel?.itemImg).into(itemImg)
        itemDesc.text = itemModel?.itemDesc.toString()
    }
}