package com.example.dummylistingapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ratings (
    @SerializedName("Source")
    var source: String? = null,
    @SerializedName("Value")
    var value: String? = null
):Parcelable