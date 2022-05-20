package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.utils.rx.Rx2EventBus
import io.reactivex.Observable
import javax.inject.Inject

class MovieListEventBus @Inject constructor(): IMovieListEventBus {
    private var topRatedList: Rx2EventBus<List<MovieListResponseModel>> = Rx2EventBus()

    override fun sendTopRated(list: List<MovieListResponseModel>) = topRatedList.onNext(list)

    override fun listenTopRated(): Observable<List<MovieListResponseModel>> = topRatedList.listen()


}