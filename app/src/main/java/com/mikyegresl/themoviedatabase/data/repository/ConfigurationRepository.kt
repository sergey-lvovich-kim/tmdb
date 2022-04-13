package com.mikyegresl.themoviedatabase.data.repository

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.service.TmdbService
import io.reactivex.Single
import javax.inject.Inject

class ConfigurationRepository @Inject constructor(
    private val tmdbService: TmdbService
): IConfigurationRepository {

    override fun getConfiguration(): Single<ConfigurationResponseModel> =
        tmdbService.getConfiguration()
}