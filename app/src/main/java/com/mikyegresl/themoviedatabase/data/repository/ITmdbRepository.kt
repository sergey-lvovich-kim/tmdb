package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import io.reactivex.Single

interface ITmdbRepository {
    fun getTopRated(page: Int): Single<TmdbModel>
    fun searchMovie(page: Int, query: String): Single<TmdbModel>
}