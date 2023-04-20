package com.tzs.picturesapp.model.data.model

import com.google.gson.annotations.SerializedName
import com.tzs.picturesapp.model.utils.BASE_URL

data class Photo(
    @SerializedName("author")
    val author: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int,
    val urlWidthHeight: String
) {
    fun getImageUrlByWidthHeight(width: Int, height: Int, id: Int): String {
        return "$BASE_URL/id/$id/$width/$height"
    }
}