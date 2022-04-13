package com.mikyegresl.themoviedatabase.data.model

data class MovieModel(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val popularity: String,
    val voteAverage: String,
    val hasVideo: Boolean = false,
)