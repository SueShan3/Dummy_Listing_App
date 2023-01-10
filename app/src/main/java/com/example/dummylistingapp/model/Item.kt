package com.example.dummylistingapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    var itemTitle: String? = null,
    var itemSubtitle: String? = null,
    var itemImg: String? = null,
    var itemDesc: String? = null
) : Parcelable