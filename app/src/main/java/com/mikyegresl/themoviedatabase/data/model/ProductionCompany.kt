package com.mikyegresl.themoviedatabase.data.model

import com.google.gson.annotations.SerializedName

data class ProductionCompany(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("origin_country")
    val country: String = "",
    @SerializedName("logo_path")
    val logoPath: String? = null,
)
