package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import com.mikyegresl.themoviedatabase.data.model.response.MovieResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.TmdbResponseModel
import com.mikyegresl.themoviedatabase.utils.Constants.EMPTY_STRING
import javax.inject.Inject

class TmdbConverter @Inject constructor(): ITmdbConverter {
    override fun toTmdbModel(model: TmdbResponseModel): TmdbModel =
        TmdbModel()

    override fun toMovieModel(model: MovieResponseModel): MovieModel =
        MovieModel(
            model.id ?: 0,
            model.title ?: EMPTY_STRING,
            model.overview ?: EMPTY_STRING,
            model.posterPath ?: EMPTY_STRING,
            model.releaseDate ?: EMPTY_STRING,
            model.popularity ?: EMPTY_STRING,
            model.voteAverage ?: EMPTY_STRING,
            model.hasVideo
        )
}