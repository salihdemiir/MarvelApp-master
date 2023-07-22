package com.mte.marvelapp.ui.home.uistate

import com.mte.marvelapp.data.remote.model.series.Series

sealed class SeriesUiState {
    object Loading : SeriesUiState()
    data class Success(val data: List<Series>?) : SeriesUiState()
    data class Error(val message: String?) : SeriesUiState()
}