package com.mikyegresl.themoviedatabase.ui.navigation

interface IMovieListRouter: IBackRouter {

    fun toMovieDetails(movieId: Long)
}