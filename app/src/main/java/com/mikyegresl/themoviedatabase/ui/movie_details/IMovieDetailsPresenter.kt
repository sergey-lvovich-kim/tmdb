package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.ui.common.mvp.IPresenter

interface IMovieDetailsPresenter: IPresenter<IMovieDetailsView> {

    fun setMovieId(movieId: Long)

    fun loadMovieDetails()

    fun loadMovieImages()

    fun loadMovieReviews()
}