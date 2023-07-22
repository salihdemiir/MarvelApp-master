package com.mte.marvelapp.data.remote.service

import com.mte.marvelapp.data.remote.model.character.CharacterResponse
import com.mte.marvelapp.data.remote.model.comic.ComicResponse
import com.mte.marvelapp.data.remote.model.event.EventsResponse
import com.mte.marvelapp.data.remote.model.series.SeriesResponse
import com.mte.marvelapp.data.remote.model.stories.StoriesResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun fetchCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash : String
    ) : CharacterResponse

    @GET("series")
    suspend fun fetchSeries(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash : String
    ) : SeriesResponse

    @GET("comics")
    suspend fun fetchComics(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash : String
    ) : ComicResponse

    @GET("stories")
    suspend fun fetchStories(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash : String
    ) : StoriesResponse

    @GET("events")
    suspend fun fetchEvents(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash : String
    ) : EventsResponse
}