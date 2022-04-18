package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import io.reactivex.Observable

interface IMovieListEventBus {

    fun sendTopRated(list: List<MovieModel>)

    fun listenTopRated(): Observable<List<MovieModel>>
}