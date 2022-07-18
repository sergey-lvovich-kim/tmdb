package com.mikyegresl.themoviedatabase.data.model.response.movie_list

import com.google.gson.annotations.SerializedName

data class TmdbResponseModel(
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("results")
    val results: List<MovieListResponseModel>? = null,
    @SerializedName("page")
    val page: Int? = null,
)