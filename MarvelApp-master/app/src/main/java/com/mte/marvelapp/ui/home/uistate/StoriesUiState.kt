package com.mte.marvelapp.ui.home.uistate

import com.mte.marvelapp.data.remote.model.stories.Stories

sealed class StoriesUiState {
    object Loading : StoriesUiState()
    data class Success (val data : List<Stories>?) : StoriesUiState()
    data class Error (val message : String?) : StoriesUiState()
}