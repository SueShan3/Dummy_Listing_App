package com.example.dummylistingapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dummylistingapp.R
import com.example.dummylistingapp.adapter.RatingAdapter
import com.example.dummylistingapp.databinding.FragmentDetailBinding
import com.example.dummylistingapp.model.Item
import com.squareup.picasso.Picasso

private const val cItem = "ITEM"

class DetailFragment : Fragment() {

    private lateinit var dataBinding: FragmentDetailBinding
    private lateinit var adapter: RatingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemModel: Item? = arguments?.getParcelable(cItem)

        itemModel?.apply {
            dataBinding.itemTitle.text = itemTitle.toString()
            dataBinding.itemSubtitle.text = getString(R.string.actor, itemSubtitle.toString())
            Picasso.get().load(itemImg).into(dataBinding.itemImage)
            dataBinding.itemDesc.text = itemDesc.toString()

            dataBinding.itemYear.text = getString(R.string.year, year.toString())
            dataBinding.itemRated.text = getString(R.string.rated, rated.toString())
            dataBinding.itemReleased.text = getString(R.string.released, released.toString())
            dataBinding.itemRuntime.text = getString(R.string.runtime, runtime.toString())
            dataBinding.itemGenre.text = getString(R.string.genre, genre.toString())
            dataBinding.itemDirector.text = getString(R.string.director, director.toString())
            dataBinding.itemWriter.text = getString(R.string.writer, writer.toString())
            dataBinding.itemLanguage.text = getString(R.string.language, language.toString())
            dataBinding.itemCountry.text = getString(R.string.country, country.toString())
            dataBinding.itemAwards.text = getString(R.string.awards, awards.toString())
        }

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = RatingAdapter()
        adapter.ratingList = itemModel?.ratings!!
        dataBinding.rvRatings.layoutManager = layoutManager
        dataBinding.rvRatings.adapter = adapter
    }
}