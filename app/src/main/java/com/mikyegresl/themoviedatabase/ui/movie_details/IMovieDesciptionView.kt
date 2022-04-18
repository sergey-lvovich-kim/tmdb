package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.ui.mvp.IView

interface IMovieDesciptionView: IView {
    fun showLoading()
    fun hideLoading()
    fun showError()

    fun onBackPressed()
    fun onRefreshClicked()
}