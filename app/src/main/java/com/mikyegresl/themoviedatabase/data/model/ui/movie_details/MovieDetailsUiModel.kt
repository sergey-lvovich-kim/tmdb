package com.mikyegresl.themoviedatabase.data.model.ui.movie_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsUiModel(
    val id: Long,
    val title: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val popularity: Float,
    val voteAverage: Float,
    val voteCount: Int,
    val posterPath: String,
    val backdropPath: String,
    val budget: Int,
    val revenue: Int,
    val runtime: Int,
    val isAdultContent: Boolean,
    val genre: String,
    val country: String,
    val productionCompany: String
): Parcelable