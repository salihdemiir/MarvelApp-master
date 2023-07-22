package com.mte.marvelapp.data.remote.model.event

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)