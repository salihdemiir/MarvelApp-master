package com.mte.marvelapp.ui.home.uistate

import com.mte.marvelapp.data.remote.model.character.Character


sealed class CharacterUiState {
    object Loading : CharacterUiState()
    data class Success(val data: List<Character>?) : CharacterUiState()
    data class Error(val message: String?) : CharacterUiState()
}