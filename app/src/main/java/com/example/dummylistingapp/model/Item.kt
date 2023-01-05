package com.example.dummylistingapp.model

data class Item(
    var itemTitle: String ?= null,
    var itemSubtitle: String ?= null,
    var itemImg: String ?= null,
    var itemDesc:String ?= null)