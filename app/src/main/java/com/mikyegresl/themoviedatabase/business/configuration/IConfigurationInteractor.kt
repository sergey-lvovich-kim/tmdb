package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import io.reactivex.Single

interface IConfigurationInteractor {
    fun getConfiguration(): Single<ConfigurationResponseModel>
}