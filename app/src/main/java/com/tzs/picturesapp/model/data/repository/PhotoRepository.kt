package com.tzs.picturesapp.model.data.repository

import com.tzs.picturesapp.model.data.api.PhotoService
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photoService: PhotoService,
) {
    suspend fun getPhotoList(page: Int) =
        photoService.getPhotos(page)

    suspend fun getPhotoInfo(id: Int) =
        photoService.getPhotoInfo(id)
}