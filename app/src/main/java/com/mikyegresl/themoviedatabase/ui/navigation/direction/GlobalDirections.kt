package com.mikyegresl.themoviedatabase.ui.navigation.direction

import com.mikyegresl.themoviedatabase.ui.movie_list.MovieListFragmentDirections
import com.mikyegresl.themoviedatabase.ui.navigation.args.movieId
import com.mikyegresl.themoviedatabase.utils.withArgs

data class ToMovieDetails(
    val movieId: Long
): NavGraphDirection(
    MovieListFragmentDirections.toMovieDetails(),
    withArgs { bundle ->
        bundle.movieId = movieId
    }
)