package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class ProductionCompanyResponseModel(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("origin_country")
    val country: String = "",
    @SerializedName("logo_path")
    val logoPath: String? = null,
)
