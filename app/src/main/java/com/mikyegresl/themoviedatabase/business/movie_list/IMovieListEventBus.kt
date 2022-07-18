package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.movie_list.MovieListResponseModel
import io.reactivex.Observable

interface IMovieListEventBus {
    fun sendTopRated(list: List<MovieListResponseModel>)
    fun listenTopRated(): Observable<List<MovieListResponseModel>>
}