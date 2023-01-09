package com.example.dummylistingapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Item(
    var itemTitle: String? = null,
    var itemSubtitle: String? = null,
    var itemImg: String? = null,
    var itemDesc: String? = null
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}