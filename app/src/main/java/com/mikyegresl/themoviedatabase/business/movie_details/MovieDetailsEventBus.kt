package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.utils.rx.Rx2EventBus
import io.reactivex.Observable
import javax.inject.Inject

class MovieDetailsEventBus @Inject constructor(): IMovieDetailsEventBus {
    private val movieId: Rx2EventBus<Long> = Rx2EventBus()

    override fun sendMovieId(movieId: Long) = this.movieId.onNext(movieId)

    override fun listenMovieId(): Observable<Long> = this.movieId.listen()
}