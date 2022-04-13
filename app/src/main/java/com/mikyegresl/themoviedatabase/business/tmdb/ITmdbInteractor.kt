package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import io.reactivex.Observable

interface ITmdbInteractor {
    fun getTopRated(): Observable<TmdbModel>
    fun searchMovie(query: String): Observable<TmdbModel>
}