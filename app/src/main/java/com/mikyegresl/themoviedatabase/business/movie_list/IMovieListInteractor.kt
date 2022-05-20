package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import io.reactivex.Observable

interface IMovieListInteractor {
    fun getTopRated(): Observable<List<MovieListResponseModel>>
    fun getPopular(): Observable<List<MovieListResponseModel>>
    fun getUpcoming(): Observable<List<MovieListResponseModel>>
    fun searchMovie(query: String): Observable<List<MovieListResponseModel>>
}