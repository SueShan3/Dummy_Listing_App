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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummylistingapp.R
import com.example.dummylistingapp.adapter.RecyclerAdapter
import com.example.dummylistingapp.databinding.FragmentListBinding
import com.example.dummylistingapp.model.Item

private const val cItem = "ITEM"

class ListFragment : Fragment(), RecyclerAdapter.OnItemClickListener {

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
        itemList.add(
            Item(
                "Dumbo",
                "Duis sagittis nisi vel ipsum imperdiet rhoncus.",
                "https://media.timeout.com/images/105526894/1024/768/image.jpg",
                "Disney’s first animated feature completely changed the face of cinema, " +
                        "but even in the age of eye-popping computer animation, it remains a " +
                        "stunning achievement. It's also equal parts thrilling, scary, funny and " +
                        "whimsical. Few films hold up as well as Snow White, and decades’s worth " +
                        "of ho-hum remakes, reimaginations and adaptations only prove how " +
                        "impressive Disney's achievement really is."
            )
        )
        itemList.add(
            Item(
                "Snow White",
                "Praesent non ex non turpis hendrerit facilisis volutpat eu nunc.",
                "https://media.timeout.com/images/105526895/1024/768/image.jpg",
                "The rat can cook! This sweetly ridiculous movie about a naive, ambitious" +
                        " rodent named Remy (charmingly voiced by Patton Oswalt), who longs to " +
                        "become a great chef is witty, clever, gently moral and dramatically " +
                        "convincing. Who doesn't love Linguini (voiced by Lou Romano), a hopeless" +
                        " human moppet controlled by the supremely talented Remy? Will they win " +
                        "over the Snow White-style villain, a power-crazed food critic named " +
                        "Anton Ego. We won't spoil the fun for the three of you out there who " +
                        "don't yet know the ending of this unexpectedly delightul Pixar masterwork."
            )
        )
        itemList.add(
            Item(
                "Wall-E",
                "Curabitur dapibus leo id neque dapibus pretium.",
                "https://media.timeout.com/images/105526889/1024/768/image.jpg",
                "Mowgli can't seem to find his place in this world. In Disney's " +
                        "rendition of the Rudyard Kipling story, this young orphan is set out " +
                        "on a quest to learn more about his identity, with the help of animal " +
                        "companions, all while warding off Shere Khan. "
            )
        )
        itemList.add(
            Item(
                "The Jungle Book",
                "Suspendisse tempor eros at tellus pulvinar dictum.",
                "https://media.timeout.com/images/105509862/1024/768/image.jpg",
                "A pompous prince gets a taste of his own medicine in this '90s " +
                        "fairytale from Disney's Renaissance. The first animated film to score " +
                        "an Oscar nomination for Best Picture. An enchantress' spell turns the " +
                        "royal into a ferocious beast, and it cannot be undone until he falls in " +
                        "love. When the beast kidnaps the town's clockmaster, his beautiful " +
                        "daughter comes to the rescue and the beast's, too."
            )
        )

        adapter = RecyclerAdapter(itemList, this@ListFragment)

        val layoutManager = LinearLayoutManager(activity)

        dataBinding.recyclerView.layoutManager = layoutManager
        dataBinding.recyclerView.adapter = adapter

        // Add query listener for search view
        dataBinding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }
        })
    }

    private fun filter(text: String) {
        val filteredList = ArrayList<Item>()

        for (item in itemList) {
            if (item.itemTitle!!.lowercase().contains(text.lowercase())) {
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(context, "No Item Found...", Toast.LENGTH_SHORT).show()
        } else {
            adapter.filterList(filteredList)
        }
    }

    override fun onItemClick(item: Item) {
        val bundle = bundleOf(cItem to item)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}