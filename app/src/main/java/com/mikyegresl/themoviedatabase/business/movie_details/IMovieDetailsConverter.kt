package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.*
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieCreditsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieWatchProvidersUiModel

interface IMovieDetailsConverter {
    fun movieDetailsResponseToUi(model: MovieDetailsResponseModel): MovieDetailsUiModel?

    fun movieImagesResponseToUi(model: MovieImagesResponseModel): List<MovieImageUiModel>

    fun movieReviewsResponseToUi(model: MovieReviewsResponseModel): List<MovieReviewUiModel>

//    fun movieCreditsResponseToUi(model: MovieCreditsResponseModel): MovieCreditsUiModel?

//    fun watchProvidersResponseToUi(model: MovieWatchProvidersResponseModel): MovieWatchProvidersUiModel?
}