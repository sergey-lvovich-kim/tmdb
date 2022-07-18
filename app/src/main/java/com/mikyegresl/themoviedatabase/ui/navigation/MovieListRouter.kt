package com.mikyegresl.themoviedatabase.ui.navigation

import android.app.Activity
import com.mikyegresl.themoviedatabase.ui.navigation.direction.NavigateBack
import com.mikyegresl.themoviedatabase.ui.navigation.direction.ToMovieDetails
import javax.inject.Inject

class MovieListRouter @Inject constructor(
    private val navigator: INavigator
): IMovieListRouter {

    override fun bind(activity: Activity, hostFragmentId: Int) {
        navigator.bind(activity, hostFragmentId)
    }

    override fun unbind() {
        navigator.unbind()
    }

    override fun toMovieDetails(movieId: Long) {
        navigator.navigate(ToMovieDetails(movieId = movieId))
    }

    override fun back() {
        navigator.navigate(NavigateBack)
    }
}