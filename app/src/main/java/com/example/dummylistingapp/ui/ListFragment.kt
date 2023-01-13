package com.example.dummylistingapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummylistingapp.R
import com.example.dummylistingapp.adapter.RecyclerAdapter
import com.example.dummylistingapp.databinding.FragmentListBinding
import com.example.dummylistingapp.model.Item
import com.example.dummylistingapp.viewmodel.ListFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val cItem = "ITEM"

class ListFragment : Fragment(), RecyclerAdapter.OnItemClickListener {

    private val viewModel: ListFragmentViewModel by viewModel()
    private lateinit var dataBinding: FragmentListBinding
    private lateinit var adapter: RecyclerAdapter
    private val itemList = ArrayList<Item>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Assign variables
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add query listener for search view
        dataBinding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loadAPIData(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = RecyclerAdapter(itemList, this@ListFragment)
        dataBinding.recyclerView.layoutManager = layoutManager
        dataBinding.recyclerView.adapter = adapter

    }

    private fun loadAPIData(text: String) {
        val filteredList = ArrayList<Item>()
        viewModel.getItemListObserver().observe(viewLifecycleOwner, Observer<Item?> {

            if (it != null) {
                filteredList.clear()
                filteredList.add(it)

                if (filteredList.isEmpty()) {
                    Toast.makeText(context, "No Item Found...", Toast.LENGTH_SHORT).show()
                } else {
                    adapter.filterList(filteredList)
                }
            } else {
                Toast.makeText(context, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall(text)
    }

    override fun onItemClick(item: Item) {
        val bundle = bundleOf(cItem to item)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}