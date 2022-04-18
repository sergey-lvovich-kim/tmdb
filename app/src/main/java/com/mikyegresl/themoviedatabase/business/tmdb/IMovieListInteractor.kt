package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import io.reactivex.Observable

interface IMovieListInteractor {
    fun getTopRated(): Observable<List<MovieModel>>
    fun searchMovie(query: String): Observable<List<MovieModel>>
}