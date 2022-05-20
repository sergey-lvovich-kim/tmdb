package com.mikyegresl.themoviedatabase.data.model

import com.google.gson.annotations.SerializedName

data class ProductionCountry(
    @SerializedName("iso_3166_1")
    val code: String = "",
    @SerializedName("name")
    val name: String = ""
)
