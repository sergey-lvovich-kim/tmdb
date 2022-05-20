package com.mikyegresl.themoviedatabase.ui.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.IView

interface IMovieListView: IView {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showEmptyView()
    fun showTopRated(topRated: List<MovieListResponseModel>)
    fun showPopular(popular: List<MovieListResponseModel>)
    fun showUpcoming(upcoming: List<MovieListResponseModel>)

    fun onMovieClicked(movieListResponse: MovieListResponseModel)
    fun onRefreshClicked()

    fun addToFavorites()
    fun goToFavorites()
    fun goToSearch()

    fun exit()
}