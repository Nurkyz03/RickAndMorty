package com.geeks.hw8.repository

import com.geeks.hw8.data.ApiService

class CharacterRepository (private val api: ApiService) : BaseRepository() {
    fun getCharacter(id: Int) = doRequest { api.getSingleCharacter(id) }
}