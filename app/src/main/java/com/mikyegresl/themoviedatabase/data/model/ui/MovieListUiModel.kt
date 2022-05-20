package com.mikyegresl.themoviedatabase.data.model.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieListUiModel(
    val id: Int? = null,
    val title: String? = null,
    val overview: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val popularity: String? = null,
    val voteAverage: String? = null,
    val hasVideo: Boolean = false,
): Parcelable
