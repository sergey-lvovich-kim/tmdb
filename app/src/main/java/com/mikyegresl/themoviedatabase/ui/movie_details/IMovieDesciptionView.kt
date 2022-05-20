package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.IView

interface IMovieDesciptionView: IView {
    fun showLoading()
    fun hideLoading()
    fun showError(error: String)

    fun showMovieDetails(listResponseModel: MovieListResponseModel)

    fun onBackPressed()
    fun onRefreshClicked()
}