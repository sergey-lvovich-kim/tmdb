package com.mikyegresl.themoviedatabase.data.service

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.TmdbModel
import com.mikyegresl.themoviedatabase.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("configuration?api_key=${Constants.API_KEY}")
    fun getConfiguration(): Single<ConfigurationResponseModel>

    @GET("movie/top_rated?api_key=${Constants.API_KEY}")
    fun getTopRated(@Query("page") page: Int): Single<TmdbModel>

    @GET("movie/recent?api_key=${Constants.API_KEY}")
    fun getRecent()

    @GET("genre/movie/list?api_key=${Constants.API_KEY}")
    fun getGenres()

    @GET("search/movie?api_key=${Constants.API_KEY}")
    fun searchMovie(
        @Query("query") query: String,
        @Query("page") page: Int,
        ): Single<TmdbModel>

}