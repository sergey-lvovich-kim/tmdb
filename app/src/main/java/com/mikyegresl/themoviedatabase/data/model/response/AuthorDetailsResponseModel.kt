package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class AuthorDetailsResponseModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("avatar_path")
    val avatar: String? = null,
    @SerializedName("rating")
    val rating: Int? = null
)
