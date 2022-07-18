package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.IView

interface IMovieDetailsView: IView {
    fun showLoading()

    fun hideLoading()

    fun showError(error: String)

    fun showMovieDetails(detailsModel: MovieDetailsUiModel)

    fun onBackPressed()

    fun onRefreshClicked()

    fun showMovieImages(images: List<MovieImageUiModel>)

    fun showMovieReviews(images: List<MovieReviewUiModel>)
}