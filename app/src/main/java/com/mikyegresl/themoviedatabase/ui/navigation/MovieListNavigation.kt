package com.mikyegresl.themoviedatabase.ui.navigation

import androidx.fragment.app.FragmentManager
import javax.inject.Inject

class MovieListNavigation @Inject constructor(
    private val fragmentManager: FragmentManager
): ITmdbNavigation {

    toMovieDetails()
}