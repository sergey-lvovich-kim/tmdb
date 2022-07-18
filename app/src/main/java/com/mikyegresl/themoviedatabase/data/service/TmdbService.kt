package com.mikyegresl.themoviedatabase.data.service

import com.mikyegresl.themoviedatabase.data.model.response.configuration.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_list.TmdbResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_details.*
import com.mikyegresl.themoviedatabase.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbService {

    /* Movie configuration */

    @GET("configuration?api_key=${Constants.API_KEY}")
    fun getConfiguration(): Single<ConfigurationResponseModel>

    @GET("genre/movie/list?api_key=${Constants.API_KEY}")
    fun getGenres()

    /* Movie list */

    @GET("movie/top_rated?api_key=${Constants.API_KEY}")
    fun getTopRated(
        @Query("language") language: String?,
        @Query("region") region: String?,
        @Query("page") page: Int,
    ): Single<TmdbResponseModel>

    @GET("movie/popular?api_key=${Constants.API_KEY}")
    fun getPopular(
        @Query("language") language: String?,
        @Query("region") region: String?,
        @Query("page") page: Int
    ): Single<TmdbResponseModel>

    @GET("movie/upcoming?api_key=${Constants.API_KEY}")
    fun getUpcoming(
        @Query("language") language: String?,
        @Query("region") region: String?,
        @Query("page") page: Int
    ): Single<TmdbResponseModel>

    /* Movie details */

    @GET("movie/{movie_id}?api_key=${Constants.API_KEY}")
    fun getMovieDetails(
        @Path("movie_id") id: Long,
        @Query("language") language: String?
    ): Single<MovieDetailsResponseModel>

    @GET("movie/{movie_id}/images?api_key=${Constants.API_KEY}")
    fun getMovieImages(
        @Path("movie_id") id: Long,
        @Query("language") language: String?
    ): Single<MovieImagesResponseModel>

    @GET("movie/{movie_id}/credits?api_key=${Constants.API_KEY}")
    fun getMovieCredits(
        @Path("movie_id") id: Long,
        @Query("language") language: String?
    ): Single<MovieCreditsResponseModel>

    @GET("movie/{movie_id}/reviews?api_key=${Constants.API_KEY}")
    fun getMovieReviews(
        @Path("movie_id") id: Long,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Single<MovieReviewsResponseModel>

//    @GET("movie/{movie_id}/watch/providers?api_key=${Constants.API_KEY}")
//    fun getMovieWatchProviders(
//        @Path("movie_id") id: Long,
//        @Query("language") language: String?
//    ): Single<MovieWatchProvidersResponseModel>

    /* Movie search */

    @GET("search/movie?api_key=${Constants.API_KEY}")
    fun searchMovie(
        @Query("query") query: String,
        @Query("page") page: Int,
    ): Single<TmdbResponseModel>
}