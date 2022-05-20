package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class MovieListResponseModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("popularity")
    val popularity: String? = null,
    @SerializedName("vote_average")
    val voteAverage: String? = null,
    @SerializedName("video")
    val hasVideo: Boolean = false,
)