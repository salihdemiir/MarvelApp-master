package com.mte.marvelapp.data.remote.model.event

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)