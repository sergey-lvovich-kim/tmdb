package com.mikyegresl.themoviedatabase.data.service

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.TmdbResponseModel
import com.mikyegresl.themoviedatabase.utils.Constants
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {
    @GET("movie/top_rated?api_key=${Constants.API_KEY}")
    fun getTopRated(@Query("page") page: Int): Single<TmdbResponseModel>

    @GET("search/movie")
    fun searchMovie(
        @Query("query") query: String,
        @Query("page") page: Int,
        ): Single<TmdbResponseModel>

    @GET("configuration?api_key=${Constants.API_KEY}")
    fun getConfiguration(): Single<ConfigurationResponseModel>
}