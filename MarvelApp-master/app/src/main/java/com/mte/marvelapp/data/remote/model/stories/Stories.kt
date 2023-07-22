package com.mte.marvelapp.data.remote.model.stories

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stories(
//    val characters: Characters,
//    val comics: Comics,
//    val creators: Creators,
//    val description: String,
//    val events: Events,
    @Json(name = "id")
    val id: Int,
//    val modified: String,
//    val originalIssue: OriginalIssue,
//    val resourceURI: String,
//    val series: Series,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail?,
    @Json(name = "title")
    val title: String,
//    val type: String
)