package com.mte.marvelapp.data.remote.model.comic

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)