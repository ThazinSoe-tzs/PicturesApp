package com.tzs.picturesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tzs.picturesapp.model.data.model.Photo
import com.tzs.picturesapp.model.data.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureInfoViewModel @Inject constructor(
    private val repository: PhotoRepository
) : ViewModel() {

    val loading = MutableLiveData<Boolean>()

    private val _photo = MutableLiveData<Photo>()
    val photo : LiveData<Photo> = _photo

    var normalURL = ""
    var blurURL =  ""
    var grayscaleURL  = ""

    fun loadPhotoInfo(id: Int) = viewModelScope.launch {
        loading.postValue(true)
        val response = repository.getPhotoInfo(id)
        if (response.isSuccessful) {
            _photo.postValue(response.body())

            normalURL = response.body()?.downloadUrl.toString()
            grayscaleURL = "${response.body()?.downloadUrl}?grayscale"
            blurURL = "${response.body()?.downloadUrl}?blur"

        }
        loading.postValue(false)
    }
}