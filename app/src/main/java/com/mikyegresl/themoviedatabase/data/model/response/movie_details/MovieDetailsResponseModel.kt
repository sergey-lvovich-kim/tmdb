package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.google.gson.annotations.SerializedName
import com.mikyegresl.themoviedatabase.data.model.Genre
import com.mikyegresl.themoviedatabase.data.model.ProductionCompany
import com.mikyegresl.themoviedatabase.data.model.ProductionCountry

data class MovieDetailsResponseModel(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("popularity")
    val popularity: String? = null,
    @SerializedName("vote_average")
    val voteAverage: String? = null,
    @SerializedName("poster_path")
    val posterPath: String? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("budget")
    val budget: Int = 0,
    @SerializedName("revenue")
    val revenue: Int = 0,
    @SerializedName("runtime")
    val runtime: Int = 0,
    @SerializedName("video")
    val hasVideo: Boolean = false,
    @SerializedName("adult")
    val isAdultContent: Boolean = false,
    @SerializedName("genres")
    val genres: List<Genre> = emptyList(),
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry> = emptyList(),
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = emptyList(),
)