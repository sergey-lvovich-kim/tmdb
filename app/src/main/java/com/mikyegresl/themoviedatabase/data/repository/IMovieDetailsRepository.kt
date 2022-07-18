package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.*
import io.reactivex.Observable

interface IMovieDetailsRepository {

    fun getMovieDetails(id: Long): Observable<MovieDetailsResponseModel>

    fun getMovieImages(id: Long): Observable<MovieImagesResponseModel>

    fun getMovieCredits(id: Long): Observable<MovieCreditsResponseModel>

    fun getMovieReviews(id: Long, page: Int): Observable<MovieReviewsResponseModel>

//    fun getMovieWatchProviders(id: Long): Observable<MovieWatchProvidersResponseModel>
}