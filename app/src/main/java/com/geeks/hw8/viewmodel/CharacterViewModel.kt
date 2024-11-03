package com.geeks.hw8.viewmodel

import androidx.lifecycle.ViewModel
import com.geeks.hw8.repository.CharactersRepository

class CharacterViewModel (private val repository: CharactersRepository): ViewModel() {
    fun getCharacters() = repository.getCharacters()
}