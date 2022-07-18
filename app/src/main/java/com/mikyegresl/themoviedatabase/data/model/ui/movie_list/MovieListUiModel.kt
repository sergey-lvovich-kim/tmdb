package com.mikyegresl.themoviedatabase.data.model.ui.movie_list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieListUiModel(
    val id: Long,
    val title: String,
    val posterPath: String,
    val releaseDate: String
): Parcelable
