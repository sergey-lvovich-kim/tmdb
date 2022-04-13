package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.ConfigurationModel
import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel

interface IConfigurationConverter {
    fun mapToConfigurationModel(model: ConfigurationResponseModel): ConfigurationModel
}