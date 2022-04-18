package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import io.reactivex.Single
import javax.inject.Inject

class TmdbRepository @Inject constructor(
    private val tmdbService: TmdbService
): ITmdbRepository {

    override fun getTopRated(page: Int): Single<TmdbModel> =
        tmdbService.getTopRated(page = page)

    override fun searchMovie(page: Int, query: String): Single<TmdbModel> =
        tmdbService.searchMovie(page = page, query = query)

}