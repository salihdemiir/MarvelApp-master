package com.mte.marvelapp.ui.home.uistate

import com.mte.marvelapp.data.remote.model.event.Events


sealed class EventsUiState {
    object Loading : EventsUiState()
    data class Success (val data : List<Events>?) : EventsUiState()
    data class Error (val message : String?) : EventsUiState()
}