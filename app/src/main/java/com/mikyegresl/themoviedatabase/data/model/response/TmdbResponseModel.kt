package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

class TmdbResponseModel(
    @SerializedName("total_results")
    val totalResults: Int? = null,
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("results")
    val results: List<MovieResponseModel>? = null,
    @SerializedName("page")
    val page: Int? = null,
)