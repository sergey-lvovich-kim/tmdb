package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.movie_list.TmdbResponseModel
import io.reactivex.Single

interface IMovieListRepository {

    fun getTopRated(page: Int): Single<TmdbResponseModel>

    fun getPopular(page: Int): Single<TmdbResponseModel>

    fun getUpcoming(page: Int): Single<TmdbResponseModel>
}