package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.utils.rx.Rx2EventBus
import io.reactivex.Observable
import javax.inject.Inject

class MovieListEventBus @Inject constructor(): IMovieListEventBus {
    private var topRatedList: Rx2EventBus<List<MovieModel>> = Rx2EventBus()

    override fun sendTopRated(list: List<MovieModel>) = topRatedList.onNext(list)

    override fun listenTopRated(): Observable<List<MovieModel>> = topRatedList.listen()


}