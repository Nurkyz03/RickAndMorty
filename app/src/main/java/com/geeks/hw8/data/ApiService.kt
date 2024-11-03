package com.geeks.hw8.data

import com.geeks.hw8.model.BaseResponse
import com.geeks.hw8.model.DetailModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int
    ) : BaseResponse

    @GET("character/{id}")
    suspend fun getSingleCharacter(
        @Path("id") id: Int
    ) : DetailModel
}