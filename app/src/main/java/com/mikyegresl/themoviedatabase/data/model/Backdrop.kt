package com.mikyegresl.themoviedatabase.data.model

import com.google.gson.annotations.SerializedName

data class Backdrop(
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("width")
    val width: Int = 0,
    @SerializedName("file_path")
    val filepath: String = "",
    @SerializedName("aspect_ratio")
    val aspectRatio: Float = 0f,
    @SerializedName("vote_average")
    val voteAverage: Int = 0,
    @SerializedName("vote_count")
    val voteCount: Int = 0,
    @SerializedName("iso_639_1")
    val productionCode: String? = null,
)
