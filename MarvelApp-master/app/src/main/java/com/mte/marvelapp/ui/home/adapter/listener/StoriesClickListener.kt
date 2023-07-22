package com.mte.marvelapp.ui.home.adapter.listener

import com.mte.marvelapp.data.remote.model.stories.Stories

interface StoriesClickListener {
    fun onStoriesClick (stories : Stories)
}