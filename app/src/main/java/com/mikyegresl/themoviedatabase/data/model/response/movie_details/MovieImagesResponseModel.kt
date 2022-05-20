package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.google.gson.annotations.SerializedName
import com.mikyegresl.themoviedatabase.data.model.Backdrop

data class MovieImagesResponseModel(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("backdrops")
    val backdrops: List<Backdrop> = emptyList(),
    @SerializedName("posters")
    val posters: List<Backdrop> = emptyList(),
)