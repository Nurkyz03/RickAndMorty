package com.geeks.hw8.ui.fragment

import androidx.lifecycle.ViewModel
import com.geeks.hw8.repository.CharacterRepository

class CharacterDetailViewModel (private val repository: CharacterRepository): ViewModel(){

    fun getCharacter(id: Int) = repository.
    getCharacter(id)
}