package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieDetailsResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.MovieDetailsUiModel

interface IMovieDetailsConverter {
    fun detailsResponseToDetailsUi(model: MovieDetailsResponseModel): MovieDetailsUiModel
}