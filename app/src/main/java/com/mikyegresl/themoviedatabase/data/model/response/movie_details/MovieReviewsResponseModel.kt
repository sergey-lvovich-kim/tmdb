package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.google.gson.annotations.SerializedName

data class MovieReviewsResponseModel(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("page")
    val page: Int? = null,
    @SerializedName("total_pages")
    val pagesCount: Int? = null,
    @SerializedName("total_results")
    val reviewsCount: Int? = null,
    @SerializedName("results")
    val reviews: List<MovieReviewResponseModel>? = null
)
