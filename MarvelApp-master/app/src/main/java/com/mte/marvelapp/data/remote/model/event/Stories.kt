package com.mte.marvelapp.data.remote.model.event

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXXX>,
    val returned: Int
)