package com.mikyegresl.themoviedatabase.ui.navigation

import androidx.fragment.app.FragmentManager
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.ui.movie_details.MovieDetailsFragment
import javax.inject.Inject

class MovieListNavigator @Inject constructor(
    fragmentManager: FragmentManager
): TmdbNavigator(fragmentManager) {

    override fun onBackPressed() {

    }

    fun toMovieDetails(listResponseModel: MovieListResponseModel) {
        replaceFragment(
            R.id.fragment_container_view,
            MovieDetailsFragment.newInstance(listResponseModel)
        )
    }


}