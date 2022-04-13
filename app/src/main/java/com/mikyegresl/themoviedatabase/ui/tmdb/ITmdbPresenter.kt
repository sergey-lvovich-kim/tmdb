package com.mikyegresl.themoviedatabase.ui.tmdb

import com.mikyegresl.themoviedatabase.ui.mvp.IPresenter

interface ITmdbPresenter: IPresenter<ITmdbView> {
    fun onViewResume()
    fun onViewPause()
}