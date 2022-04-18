package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.ui.mvp.IPresenter

interface IMovieDetailsPresenter: IPresenter<IMovieDesciptionView> {
    fun loadGenres()
}