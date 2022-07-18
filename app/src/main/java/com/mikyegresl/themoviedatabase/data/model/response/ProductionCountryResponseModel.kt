package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class ProductionCountryResponseModel(
    @SerializedName("iso_3166_1")
    val code: String = "",
    @SerializedName("name")
    val name: String = ""
)
