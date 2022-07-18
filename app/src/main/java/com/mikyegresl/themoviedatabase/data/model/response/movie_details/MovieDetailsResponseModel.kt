package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.google.gson.annotations.SerializedName
import com.mikyegresl.themoviedatabase.data.model.Genre
import com.mikyegresl.themoviedatabase.data.model.response.ProductionCompanyResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.ProductionCountryResponseModel

data class MovieDetailsResponseModel(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("original_title")
    val originalTitle: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("popularity")
    val popularity: Float? = null,
    @SerializedName("vote_average")
    val voteAverage: Float? = null,
    @SerializedName("vote_count")
    val voteCount: Int? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("budget")
    val budget: Int? = null,
    @SerializedName("revenue")
    val revenue: Int? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("video")
    val hasVideo: Boolean? = null,
    @SerializedName("adult")
    val isAdultContent: Boolean? = null,
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountryResponseModel>? = null,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyResponseModel>? = null,
)