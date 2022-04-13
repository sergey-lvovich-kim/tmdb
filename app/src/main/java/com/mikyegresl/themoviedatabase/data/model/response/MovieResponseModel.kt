package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class MovieResponseModel(
    val id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    val popularity: String? = null,
    @SerializedName("vote_average")
    val voteAverage: String? = null,
    @SerializedName("video")
    val hasVideo: Boolean = false,
)