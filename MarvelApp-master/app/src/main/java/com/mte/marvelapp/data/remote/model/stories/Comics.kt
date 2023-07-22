package com.mte.marvelapp.data.remote.model.stories

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)