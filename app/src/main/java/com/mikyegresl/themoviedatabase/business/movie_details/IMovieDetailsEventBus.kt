package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import io.reactivex.Observable

interface IMovieDetailsEventBus {
    fun sendMovieDetails(listResponseModel: MovieListResponseModel)
    fun listenMovieDetails(): Observable<MovieListResponseModel>
}