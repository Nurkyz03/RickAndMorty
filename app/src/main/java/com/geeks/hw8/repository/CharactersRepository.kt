package com.geeks.hw8.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.geeks.hw8.data.ApiService
import com.geeks.hw8.data.paging.PagingSource
import com.geeks.hw8.utils.Resource
import kotlinx.coroutines.Dispatchers

class CharactersRepository (private val api: ApiService) {

    fun getCharacters(): LiveData<Resource<PagingData<Character>>> {
        return liveData {
            emit(Resource.Loading())
            try {
                val pager = Pager(
                    config = PagingConfig(
                        pageSize = 10,
                        enablePlaceholders = false
                    ),
                    pagingSourceFactory = { PagingSource(api) }
                ).liveData

                emitSource(pager.map { Resource.Success(it) })

            } catch (e: Exception) {
                emit(Resource.Error("Failed to load characters: ${e.message}"))
            }
        }
    }
}