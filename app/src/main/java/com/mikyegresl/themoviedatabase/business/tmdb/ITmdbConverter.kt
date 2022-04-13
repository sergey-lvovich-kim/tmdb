package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import com.mikyegresl.themoviedatabase.data.model.response.MovieResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.TmdbResponseModel

interface ITmdbConverter {
    fun toTmdbModel(model: TmdbResponseModel): TmdbModel
    fun toMovieModel(model: MovieResponseModel): MovieModel
}