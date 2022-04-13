package com.mikyegresl.themoviedatabase.ui.mvp

interface IPresenter<in T: IView> {
    fun bindView(view: T)
    fun unbindView()
    fun onViewReady()
    fun onDestroy()
}