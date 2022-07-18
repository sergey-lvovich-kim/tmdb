package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.configuration.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.configuration.ConfigurationUiModel

interface IConfigurationConverter {
    fun mapToConfigurationModel(model: ConfigurationResponseModel): ConfigurationUiModel
}