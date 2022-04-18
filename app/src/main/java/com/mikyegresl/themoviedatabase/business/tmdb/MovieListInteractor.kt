package com.mikyegresl.themoviedatabase.business.tmdb

import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.data.repository.ITmdbRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieListInteractor @Inject constructor(
    private val repository: ITmdbRepository,
    private val converter: IMovieListConverter,
): IMovieListInteractor {

    companion object {
        private const val DEFAULT_PAGE = 1
        private const val DEFAULT_PER_PAGE = 20
    }

    override fun getTopRated(): Observable<List<MovieModel>> =
        repository.getTopRated(DEFAULT_PAGE)
            .map { it.results ?: emptyList() }
            .toObservable()

    override fun searchMovie(query: String): Observable<List<MovieModel>> =
        repository.searchMovie(DEFAULT_PAGE, query)
            .map { it.results ?: emptyList() }
            .toObservable()
}