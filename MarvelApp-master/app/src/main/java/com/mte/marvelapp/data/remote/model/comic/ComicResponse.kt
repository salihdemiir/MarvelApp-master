package com.mte.marvelapp.data.remote.model.comic

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ComicResponse(
    @Json(name = "attributionHTML")
    val attributionHTML: String,
    @Json(name = "attributionText")
    val attributionText: String,
    @Json(name = "code")
    val code: Int,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "etag")
    val etag: String,
    @Json(name = "status")
    val status: String
)