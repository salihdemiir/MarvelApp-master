package com.mte.marvelapp.data.remote.model.event

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Events(
//    val characters: Characters,
//    val comics: Comics,
//    val creators: Creators,
//    val description: String,
//    val end: String,
    @Json(name = "id")
    val id: Int,
//    val modified: String,
//    val next: Next,
//    val previous: Previous,
//    val resourceURI: String,
//    val series: Series,
//    val start: String,
//    val stories: Stories,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail,
    @Json(name = "title")
    val title: String,
//    val urls: List<Url>
)