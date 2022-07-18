package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.*
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import io.reactivex.Observable
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(
    private val apiService: TmdbService
): IMovieDetailsRepository {
    override fun getMovieDetails(id: Long): Observable<MovieDetailsResponseModel> =
        apiService.getMovieDetails(id = id, language = null).toObservable()

    override fun getMovieImages(id: Long): Observable<MovieImagesResponseModel> =
        apiService.getMovieImages(id = id, language = null).toObservable()

    override fun getMovieCredits(id: Long): Observable<MovieCreditsResponseModel> =
        apiService.getMovieCredits(id = id, language = null).toObservable()

    override fun getMovieReviews(id: Long, page: Int): Observable<MovieReviewsResponseModel> =
        apiService.getMovieReviews(
            id = id,
            page = page,
            language = null
        ).toObservable()

//    override fun getMovieWatchProviders(id: Long): Observable<MovieWatchProvidersResponseModel> =
//        apiService.getMovieWatchProviders(id = id, language = null).toObservable()
}