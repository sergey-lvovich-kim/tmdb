package com.mikyegresl.themoviedatabase.data.model.response

import com.google.gson.annotations.SerializedName

data class ConfigurationResponseModel(
    @SerializedName("change_keys")
    val changeKeys: List<String>?,
    @SerializedName("images")
    val imagesConfiguration: ImagesConfigurationResponseModel?
)