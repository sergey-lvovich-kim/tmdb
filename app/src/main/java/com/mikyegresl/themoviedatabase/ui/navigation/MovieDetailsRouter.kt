package com.mikyegresl.themoviedatabase.ui.navigation

import android.app.Activity
import com.mikyegresl.themoviedatabase.ui.navigation.direction.NavigateBack
import javax.inject.Inject

class MovieDetailsRouter @Inject constructor(
    private val navigator: INavigator
): IMovieDetailsRouter {

    override fun bind(activity: Activity, hostFragmentId: Int) {
        TODO("Not yet implemented")
    }

    override fun unbind() {
        TODO("Not yet implemented")
    }

    override fun back() {
        navigator.navigate(NavigateBack)
    }
}