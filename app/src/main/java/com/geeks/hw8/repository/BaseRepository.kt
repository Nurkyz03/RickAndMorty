package com.geeks.hw8.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.geeks.hw8.utils.Resource
import kotlinx.coroutines.Dispatchers

abstract class BaseRepository {
    protected fun <T> doRequest(request: suspend () -> T): LiveData<Resource<T>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            try {
                val response = request()
                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error("Network error: ${e.message}"))
            }
        }
    }
}