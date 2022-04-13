package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import io.reactivex.Observable

interface IConfigurationEventBus {

    fun sendConfiguration(configurationModel: ConfigurationResponseModel)
    fun listenToConfiguration(): Observable<ConfigurationResponseModel>
}