package com.mte.marvelapp.ui.home.uistate

import com.mte.marvelapp.data.remote.model.comic.Comic

sealed class ComicsUiState {
    object Loading : ComicsUiState()
    data class Success (val data : List<Comic>?) : ComicsUiState()
    data class Error (val message : String?) : ComicsUiState()
}