package com.mikyegresl.themoviedatabase.ui.movie_list

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.ui.mvp.IView

interface IMovieListView: IView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showEmptyView()
    fun showTopRated(topRated: List<MovieModel>)
    fun showRecent(recent: List<MovieModel>)

    fun onMovieClicked(movie: MovieModel)
    fun onRefreshClicked()

    fun addToFavorites()
    fun goToFavorites()
    fun goToSearch()

    fun exit()
}