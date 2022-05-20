package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.utils.rx.Rx2EventBus
import io.reactivex.Observable
import javax.inject.Inject

class MovieDetailsEventBus @Inject constructor(): IMovieDetailsEventBus {
    private val movieListResponseDetails: Rx2EventBus<MovieListResponseModel> = Rx2EventBus()

    override fun sendMovieDetails(listResponseModel: MovieListResponseModel) = movieListResponseDetails.onNext(listResponseModel)

    override fun listenMovieDetails(): Observable<MovieListResponseModel> = movieListResponseDetails.listen()
}