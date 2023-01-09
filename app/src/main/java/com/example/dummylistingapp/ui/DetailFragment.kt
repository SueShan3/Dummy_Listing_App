package com.example.dummylistingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.dummylistingapp.R
import com.example.dummylistingapp.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class DetailFragment : BaseFragment() {

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
        val btnEditItem = view.findViewById<FloatingActionButton>(R.id.btn_edit_item)

        itemTitle.text = itemModel?.itemTitle.toString()
        itemSubtitle.text = itemModel?.itemSubtitle.toString()
        Picasso.get().load(itemModel?.itemImg).into(itemImg)
        itemDesc.text = itemModel?.itemDesc.toString()

        btnEditItem.setOnClickListener {
            val bundle = bundleOf("itemModel" to itemModel)
            findNavController().navigate(R.id.action_detailFragment_to_addItemFragment, bundle)
        }
    }
}