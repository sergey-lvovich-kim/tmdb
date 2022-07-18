package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.movie_list.MovieListResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_list.TmdbResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel
import com.mikyegresl.themoviedatabase.utils.Constants.EMPTY_STRING
import javax.inject.Inject

class MovieListConverter @Inject constructor(): IMovieListConverter {

    private fun mapMovie(model: MovieListResponseModel): MovieListUiModel =
        MovieListUiModel(
            id = model.id ?: 0,
            title = model.title ?: EMPTY_STRING,
            posterPath = model.posterPath ?: EMPTY_STRING,
            releaseDate = model.releaseDate ?: EMPTY_STRING
        )

    override fun tmdbResponseToMovieUi(model: TmdbResponseModel): List<MovieListUiModel> =
        model.results?.map { mapMovie(it) } ?: emptyList()
}