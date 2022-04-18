package com.mikyegresl.themoviedatabase.ui.mvp

interface IPresenter<in V: IView> {
    fun bindView(view: V)
    fun unbindView()
    fun onViewReady()
    fun onViewResume()
    fun onViewPause()
    fun onDestroy()
}