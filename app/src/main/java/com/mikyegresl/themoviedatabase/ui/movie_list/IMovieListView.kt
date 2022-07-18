package com.mikyegresl.themoviedatabase.ui.movie_list

import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.IView

interface IMovieListView: IView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showEmptyView()
    fun showTopRated(topRated: List<MovieListUiModel>)
    fun showPopular(popular: List<MovieListUiModel>)
    fun showUpcoming(upcoming: List<MovieListUiModel>)

    fun onMovieClicked(movieId: Long)
    fun onRefreshClicked()

    fun addToFavorites()
    fun goToFavorites()
    fun goToSearch()

    fun exit()
}