package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.TmdbResponseModel
import io.reactivex.Single

interface ITmdbRepository {

    fun getTopRated(page: Int): Single<TmdbResponseModel>

    fun getPopular(page: Int): Single<TmdbResponseModel>

    fun getUpcoming(page: Int): Single<TmdbResponseModel>

    fun searchMovie(page: Int, query: String): Single<TmdbResponseModel>
}