package com.example.dummylistingapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.dummylistingapp.R
import com.example.dummylistingapp.db.ItemDatabase
import com.example.dummylistingapp.model.Item
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class AddItemFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editTitle = view.findViewById<EditText>(R.id.edit_txt_title)
        val editSubtitle = view.findViewById<EditText>(R.id.edit_txt_subtitle)
        val editDesc = view.findViewById<EditText>(R.id.edit_txt_desc)
        val editImageUrl = view.findViewById<EditText>(R.id.edit_txt_image_url)
        val imagePreview = view.findViewById<ImageView>(R.id.image_preview)
        val btnSave = view.findViewById<Button>(R.id.btn_save)

        var itemModel: Item? = null
        itemModel = arguments?.getParcelable("itemModel")

        editTitle.setText(itemModel?.itemTitle)
        editSubtitle.setText(itemModel?.itemSubtitle)
        editDesc.setText(itemModel?.itemDesc)
        editImageUrl.setText(itemModel?.itemImg)
        Picasso.get().load(itemModel?.itemImg).placeholder(R.drawable.ic_image).into(imagePreview)

        editImageUrl.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Picasso.get().load(p0.toString()).error(R.drawable.ic_broken_image)
                    .into(imagePreview)
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        btnSave.setOnClickListener {
            val title = editTitle.text.toString()
            val subtitle = editSubtitle.text.toString()
            val desc = editDesc.text.toString()
            val image = editImageUrl.text.toString()

            if (title.isEmpty()) {
                editTitle.error = "title required"
                editTitle?.requestFocus()
                return@setOnClickListener
            }

            if (subtitle.isEmpty()) {
                editSubtitle?.error = "subtitle required"
                editSubtitle?.requestFocus()
                return@setOnClickListener
            }

            if (desc.isEmpty()) {
                editDesc?.error = "description required"
                editDesc?.requestFocus()
                return@setOnClickListener
            }

            if (image.isEmpty()) {
                editImageUrl?.error = "imageUrl required"
                editImageUrl?.requestFocus()
                return@setOnClickListener
            }

            launch {
                context?.let {
                    val item = Item(title, subtitle, image, desc)

                    if (itemModel == null) {
                        //perform insert item task
                        ItemDatabase(it).getItemDao().addItem(item)
                        Toast.makeText(context, "Item Added", Toast.LENGTH_SHORT).show()
                    } else {
                        //perform update item task
                        item.id = itemModel.id
                        ItemDatabase(it).getItemDao().updateItem(item)
                        Toast.makeText(context, "Item Updated", Toast.LENGTH_SHORT).show()
                    }
                    findNavController().navigate(R.id.action_addItemFragment_to_listFragment)
                }
            }
        }
    }
}