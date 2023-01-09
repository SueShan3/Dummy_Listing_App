package com.example.dummylistingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.R
import com.example.dummylistingapp.adapter.RecyclerAdapter
import com.example.dummylistingapp.db.ItemDatabase
import com.example.dummylistingapp.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class ListFragment : BaseFragment(), RecyclerAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        launch {
            context?.let {
                val itemList = ItemDatabase(it).getItemDao().getAllItems()
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = RecyclerAdapter(itemList, this@ListFragment)
                }
            }
        }

        val btnAddItem = view.findViewById<FloatingActionButton>(R.id.btn_add_item)
        btnAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addItemFragment)
        }
    }

    override fun onItemClick(item: Item) {
        val bundle = bundleOf("item" to item)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}