package com.mikyegresl.themoviedatabase.ui.movie_list

import com.mikyegresl.themoviedatabase.ui.common.mvp.IPresenter

interface IMovieListPresenter: IPresenter<IMovieListView> {
    fun loadTopRated()
    fun loadPopular()
    fun loadUpcoming()
}