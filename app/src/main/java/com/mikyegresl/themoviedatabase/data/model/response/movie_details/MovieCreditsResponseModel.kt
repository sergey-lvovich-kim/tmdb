package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.mikyegresl.themoviedatabase.data.model.Cast

data class MovieCreditsResponseModel(
    val id: Long = 0,
    val actors: List<Cast> = emptyList(),
)
