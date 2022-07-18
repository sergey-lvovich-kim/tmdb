package com.mikyegresl.themoviedatabase.business.movie_list

import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel
import com.mikyegresl.themoviedatabase.data.repository.IMovieListRepository
import io.reactivex.Observable
import javax.inject.Inject

class MovieListInteractor @Inject constructor(
    private val repository: IMovieListRepository,
    private val converter: IMovieListConverter
): IMovieListInteractor {

    companion object {
        private const val DEFAULT_PAGE = 1
    }

    override fun getTopRated(): Observable<List<MovieListUiModel>> =
        repository.getTopRated(DEFAULT_PAGE)
            .map { converter.tmdbResponseToMovieUi(it) }
            .toObservable()

    override fun getPopular(): Observable<List<MovieListUiModel>> =
        repository.getPopular(DEFAULT_PAGE)
            .map { converter.tmdbResponseToMovieUi(it) }
            .toObservable()

    override fun getUpcoming(): Observable<List<MovieListUiModel>> =
        repository.getUpcoming(DEFAULT_PAGE)
            .map { converter.tmdbResponseToMovieUi(it) }
            .toObservable()
}