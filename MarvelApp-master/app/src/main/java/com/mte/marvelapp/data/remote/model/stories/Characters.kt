package com.mte.marvelapp.data.remote.model.stories

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)