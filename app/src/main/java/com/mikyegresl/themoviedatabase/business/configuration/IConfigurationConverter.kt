package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.ConfigurationUiModel

interface IConfigurationConverter {
    fun mapToConfigurationModel(model: ConfigurationResponseModel): ConfigurationUiModel
}