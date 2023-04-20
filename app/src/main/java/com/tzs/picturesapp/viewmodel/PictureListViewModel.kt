package com.tzs.picturesapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.tzs.picturesapp.model.data.repository.PhotoRepository
import com.tzs.picturesapp.model.paging.PhotoPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PictureListViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {
    //Get photo list by paging
    val photoList = Pager(PagingConfig(1)) {
        PhotoPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}