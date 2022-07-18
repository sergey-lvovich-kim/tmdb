package com.mikyegresl.themoviedatabase.ui.navigation.args

import android.os.Bundle

private const val MOVIE_ID = "MOVIE_ID"
var Bundle.movieId: Long
    get() = this.getLong(MOVIE_ID)
    set(value) = this.putLong(MOVIE_ID, value)