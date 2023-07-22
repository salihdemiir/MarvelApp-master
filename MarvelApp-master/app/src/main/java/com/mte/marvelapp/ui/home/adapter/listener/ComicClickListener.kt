package com.mte.marvelapp.ui.home.adapter.listener

import com.mte.marvelapp.data.remote.model.comic.Comic

interface ComicClickListener {
    fun onComicClick(comic : Comic)
}