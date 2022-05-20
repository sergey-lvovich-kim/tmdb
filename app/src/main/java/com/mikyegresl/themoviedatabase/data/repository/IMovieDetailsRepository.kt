package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieCreditsResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieDetailsResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieImagesResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieWatchProvidersResponseModel
import io.reactivex.Observable

interface IMovieDetailsRepository {

    fun getMovieDetails(id: Long): Observable<MovieDetailsResponseModel>

    fun getMovieImages(id: Long): Observable<MovieImagesResponseModel>

    fun getMovieCredits(id: Long): Observable<MovieCreditsResponseModel>

    fun getMovieWatchProviders(id: Long): Observable<MovieWatchProvidersResponseModel>
}