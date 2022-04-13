package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import io.reactivex.Single

interface IConfigurationRepository {
    fun getConfiguration(): Single<ConfigurationResponseModel>
}