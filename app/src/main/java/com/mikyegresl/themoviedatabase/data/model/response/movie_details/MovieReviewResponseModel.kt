package com.mikyegresl.themoviedatabase.data.model.response.movie_details

import com.google.gson.annotations.SerializedName
import com.mikyegresl.themoviedatabase.data.model.response.AuthorDetailsResponseModel

data class MovieReviewResponseModel(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("authorDetails")
    val authorDetailsResponseModel: AuthorDetailsResponseModel? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    @SerializedName("updated_at")
    val updatedAt: String? = null
)
