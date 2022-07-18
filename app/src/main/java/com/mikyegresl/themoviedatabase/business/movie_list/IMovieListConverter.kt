package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.movie_list.TmdbResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel

interface IMovieListConverter {
    fun tmdbResponseToMovieUi(model: TmdbResponseModel): List<MovieListUiModel>
}