package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel
import io.reactivex.Observable

interface IMovieListInteractor {
    fun getTopRated(): Observable<List<MovieListUiModel>>
    fun getPopular(): Observable<List<MovieListUiModel>>
    fun getUpcoming(): Observable<List<MovieListUiModel>>
}