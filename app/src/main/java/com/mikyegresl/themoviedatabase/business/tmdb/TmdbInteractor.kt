package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import com.mikyegresl.themoviedatabase.data.repository.ITmdbRepository
import io.reactivex.Observable
import javax.inject.Inject

class TmdbInteractor @Inject constructor(
    private val repository: ITmdbRepository,
    private val converter: ITmdbConverter,
): ITmdbInteractor {

    companion object {
        private const val DEFAULT_PAGE = 0
    }

    override fun getTopRated(): Observable<TmdbModel> =
        repository.getTopRated(DEFAULT_PAGE)
            .map { converter.toTmdbModel(it) }
            .toObservable()

    override fun searchMovie(query: String): Observable<TmdbModel> =
        repository.searchMovie(DEFAULT_PAGE, query)
            .map { converter.toTmdbModel(it) }
            .toObservable()
}