package com.mikyegresl.themoviedatabase.data.model

import com.google.gson.annotations.SerializedName

class TmdbModel(
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("results")
    val results: List<MovieModel>? = null,
    @SerializedName("page")
    val page: Int? = null,
)