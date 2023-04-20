package com.tzs.picturesapp.model.data.api

import com.tzs.picturesapp.model.data.model.Photo
import com.tzs.picturesapp.model.utils.LIMIT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {
    @GET("/v2/list")
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("limit") limit: Int = LIMIT
    ): Response<List<Photo>>
}