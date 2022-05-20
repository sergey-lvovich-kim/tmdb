package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.data.repository.ITmdbRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieListInteractor @Inject constructor(
    private val repository: ITmdbRepository,
): IMovieListInteractor {

    companion object {
        private const val DEFAULT_PAGE = 1
    }

    override fun getTopRated(): Observable<List<MovieListResponseModel>> =
        repository.getTopRated(DEFAULT_PAGE)
            .map { it.results ?: emptyList() }
            .toObservable()

    override fun getPopular(): Observable<List<MovieListResponseModel>> =
        repository.getPopular(DEFAULT_PAGE)
            .map { it.results ?: emptyList() }
            .toObservable()

    override fun getUpcoming(): Observable<List<MovieListResponseModel>> =
        repository.getUpcoming(DEFAULT_PAGE)
            .map { it.results ?: emptyList() }
            .toObservable()

    override fun searchMovie(query: String): Observable<List<MovieListResponseModel>> =
        repository.searchMovie(DEFAULT_PAGE, query)
            .map { it.results ?: emptyList() }
            .toObservable()
}