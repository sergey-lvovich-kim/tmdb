package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.TmdbResponseModel
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import io.reactivex.Single
import javax.inject.Inject

class TmdbRepository @Inject constructor(
    private val tmdbService: TmdbService
): ITmdbRepository {

    override fun getTopRated(page: Int): Single<TmdbResponseModel> =
        tmdbService.getTopRated(language = null, region = null, page = page)

    override fun getPopular(page: Int): Single<TmdbResponseModel> =
        tmdbService.getPopular(language = null, region = null, page = page)

    override fun getUpcoming(page: Int): Single<TmdbResponseModel> =
        tmdbService.getUpcoming(language = null, region = null, page = page)

    override fun searchMovie(page: Int, query: String): Single<TmdbResponseModel> =
        tmdbService.searchMovie(page = page, query = query)

}