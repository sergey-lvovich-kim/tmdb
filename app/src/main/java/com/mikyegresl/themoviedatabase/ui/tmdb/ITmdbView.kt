package com.mikyegresl.themoviedatabase.ui.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.ui.mvp.IView

interface ITmdbView: IView {

    fun showLoading()
    fun hideLoading()
    fun showEmptyView()
    fun showTopRated(topRated: List<MovieModel>)
    fun showRecent(recent: List<MovieModel>)
    fun onMovieClicked()
    fun addToFavorites()
    fun goToFavorites()
    fun goToSearch()
    fun showError(message: String)
    fun exit()
}