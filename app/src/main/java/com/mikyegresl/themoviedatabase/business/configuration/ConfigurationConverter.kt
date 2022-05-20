package com.mikyegresl.themoviedatabase.business.configuration

import android.util.Log
import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.ConfigurationUiModel
import com.mikyegresl.themoviedatabase.utils.Constants.EMPTY_STRING
import javax.inject.Inject

class ConfigurationConverter @Inject constructor(

): IConfigurationConverter {

    override fun mapToConfigurationModel(model: ConfigurationResponseModel): ConfigurationUiModel {
        val configuration = ConfigurationUiModel(
            imageUrl = model.imagesConfiguration?.secureBaseUrl ?: EMPTY_STRING,
            posterSize = model.imagesConfiguration?.let {
                if (it.posterSizes.isNullOrEmpty()) EMPTY_STRING else it.posterSizes[0]
            } ?: EMPTY_STRING,
            profileSize = model.imagesConfiguration?.let {
                if (it.profileSizes.isNullOrEmpty()) EMPTY_STRING else it.profileSizes[0]
            } ?: EMPTY_STRING,
            logoSize = model.imagesConfiguration?.let {
                if (it.logoSizes.isNullOrEmpty()) EMPTY_STRING else it.logoSizes[0]
            } ?: EMPTY_STRING,
            stillSize = model.imagesConfiguration?.let {
                if (it.stillSizes.isNullOrEmpty()) EMPTY_STRING else it.stillSizes[0]
            } ?: EMPTY_STRING,
        )

        Log.i(TAG, "mapToConfigurationModel(): configuration=$configuration")

        return configuration
    }
}

private val TAG = ConfigurationConverter::class.java.name