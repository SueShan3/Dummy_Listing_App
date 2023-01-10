package com.example.dummylistingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dummylistingapp.R
import com.example.dummylistingapp.adapter.RecyclerAdapter
import com.example.dummylistingapp.model.Item
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(), RecyclerAdapter.OnItemClickListener {

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

        val itemList = ArrayList<Item>()

        itemList.add(
            Item(
                "The Lady and the Tramp",
                "Integer congue neque eu turpis fringilla venenatis.",
                "https://media.timeout.com/images/105509877/1024/768/image.jpg",
                "Our band of film critics named Pinocchio the best animated film of all " +
                        "time, but you don’t need to be a historian to see why the tale of the " +
                        "little wooden boy seeking to become real is the high water mark for " +
                        "Disney. From the puppet’s ever-growing nose to the climax within a " +
                        "whale, the Blue Fairy to Jiminy Cricket singing ‘when you wish upon a " +
                        "star,’ nearly every minute is iconic and awe-inspiring."
            )
        )
        itemList.add(
            Item(
                "Peter Pan",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                "https://media.timeout.com/images/105526885/1024/768/image.jpg",
                "Mr. Incredible and Elastigirl are forced to play it cool when the " +
                        "government forbids super-hero activity. Although they should take an " +
                        "opportunity to catch up on some r&r during the hiatus, they can't help " +
                        "but miss stopping crime. Soon enough, their efforts are needed once " +
                        "again. This is top-tier superhero stuff that stands tall alongside " +
                        "Marvel and DC’s best."
            )
        )

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter(itemList, this@ListFragment)
        }
    }

    override fun onItemClick(item: Item) {
        val bundle = bundleOf("item" to item)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}