package com.mikyegresl.themoviedatabase.business.movie_details

import io.reactivex.Observable

interface IMovieDetailsEventBus {

    fun sendMovieId(movieId: Long)

    fun listenMovieId(): Observable<Long>
}