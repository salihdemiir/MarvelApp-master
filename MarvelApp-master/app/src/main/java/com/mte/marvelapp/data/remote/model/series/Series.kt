package com.mte.marvelapp.data.remote.model.series

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Series(
    @Json(name = "characters")
    val characters: Characters,
    @Json(name = "comics")
    val comics: Comics,
    @Json(name = "creators")
    val creators: Creators,
    @Json(name = "description")
    val description: String?,
    @Json(name = "endYear")
    val endYear: Int,
    @Json(name = "events")
    val events: Events,
    @Json(name = "id")
    val id: Int,
    @Json(name = "modified")
    val modified: String,
    @Json(name = "next")
    val next: Next?,
    @Json(name = "previous")
    val previous: Any?,
    @Json(name = "rating")
    val rating: String?,
    @Json(name = "resourceURI")
    val resourceURI: String,
    @Json(name = "startYear")
    val startYear: Int,
    @Json(name = "stories")
    val stories: Stories,
    @Json(name = "thumbnail")
    val thumbnail: Thumbnail,
    @Json(name = "title")
    val title: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "urls")
    val urls: List<Url>
)