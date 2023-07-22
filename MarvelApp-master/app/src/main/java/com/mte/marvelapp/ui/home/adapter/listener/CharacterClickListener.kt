package com.mte.marvelapp.ui.home.adapter.listener

import com.mte.marvelapp.data.remote.model.character.Character

interface CharacterClickListener {
    fun onCharacterClick(character : Character)
}