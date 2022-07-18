package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.configuration.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.data.repository.IConfigurationRepository
import io.reactivex.Single
import javax.inject.Inject

class ConfigurationInteractor @Inject constructor(
    private val repository: IConfigurationRepository,
    private val eventBus: IConfigurationEventBus,
): IConfigurationInteractor {

    override fun getConfiguration(): Single<ConfigurationResponseModel> =
        repository.getConfiguration()
            .doOnSuccess(eventBus::sendConfiguration)
}