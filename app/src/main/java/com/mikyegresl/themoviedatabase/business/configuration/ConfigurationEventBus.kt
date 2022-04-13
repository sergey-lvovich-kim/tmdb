package com.mikyegresl.themoviedatabase.business.configuration

import com.mikyegresl.themoviedatabase.data.model.response.ConfigurationResponseModel
import com.mikyegresl.themoviedatabase.utils.rx.Rx2EventBus
import io.reactivex.Observable
import javax.inject.Inject

class ConfigurationEventBus @Inject constructor(

): IConfigurationEventBus {

    private val configuration: Rx2EventBus<ConfigurationResponseModel> = Rx2EventBus()

    override fun sendConfiguration(configurationModel: ConfigurationResponseModel) = configuration.onNext(configurationModel)

    override fun listenToConfiguration(): Observable<ConfigurationResponseModel> = configuration.listen()
}