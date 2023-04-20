package com.tzs.picturesapp.model.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tzs.picturesapp.model.data.model.Photo
import com.tzs.picturesapp.model.data.repository.PhotoRepository
import retrofit2.HttpException

class PhotoPagingSource(
    private val repository: PhotoRepository,
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getPhotoList(currentPage)
            val data = response.body()
            val responseData = mutableListOf<Photo>()
            if (data != null) {
                responseData.addAll(data)
            }

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }

    }


    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return null
    }

}