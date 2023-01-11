package com.example.dummylistingapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    @SerializedName("Title")
    var itemTitle: String? = null,
    @SerializedName("Year")
    var year: String? = null,
    @SerializedName("Rated")
    var rated: String? = null,
    @SerializedName("Released")
    var released: String? = null,
    @SerializedName("Runtime")
    var runtime: String? = null,
    @SerializedName("Genre")
    var genre: String? = null,
    @SerializedName("Director")
    var director: String? = null,
    @SerializedName("Writer")
    var writer: String? = null,
    @SerializedName("Actors")
    var itemSubtitle: String? = null,
    @SerializedName("Poster")
    var itemImg: String? = null,
    @SerializedName("Language")
    var language: String? = null,
    @SerializedName("Country")
    var country: String? = null,
    @SerializedName("Awards")
    var awards: String? = null,
    @SerializedName("Plot")
    var itemDesc: String? = null,
    @SerializedName("Ratings")
    var ratings: List<Ratings>? = null,
) : Parcelable