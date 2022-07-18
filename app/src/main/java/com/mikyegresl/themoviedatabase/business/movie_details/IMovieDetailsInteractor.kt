package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieCreditsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieWatchProvidersUiModel
import io.reactivex.Observable

interface IMovieDetailsInteractor {

    companion object {
        private const val DEFAULT_PAGE = 1
    }

    fun getMovieDetails(id: Long): Observable<MovieDetailsUiModel>

    fun getMovieImages(id: Long): Observable<List<MovieImageUiModel>>

//    fun getMovieCredits(id: Long): Observable<MovieCreditsUiModel>

    fun getMovieReviews(id: Long, page: Int = DEFAULT_PAGE): Observable<List<MovieReviewUiModel>>

//    fun getMovieWatchProviders(id: Long): Observable<MovieWatchProvidersUiModel>
}