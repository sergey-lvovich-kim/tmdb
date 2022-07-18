package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.configuration.ConfigurationResponseModel
import io.reactivex.Single

interface IConfigurationInteractor {
    fun getConfiguration(): Single<ConfigurationResponseModel>
}