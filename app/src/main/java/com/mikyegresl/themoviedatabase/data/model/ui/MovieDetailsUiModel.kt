package com.mikyegresl.themoviedatabase.data.model.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetailsUiModel(
    val id: Long = 0,
    val title: String? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val popularity: String? = null,
    val voteAverage: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val budget: Int = 0,
    val revenue: Int = 0,
    val runtime: Int = 0,
    val hasVideo: Boolean = false,
    val isAdultContent: Boolean = false,
    val genres: List<String> = emptyList(),
    val productionCountries: List<String> = emptyList(),
    val productionCompanies: List<String> = emptyList(),
): Parcelable