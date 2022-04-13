package com.mikyegresl.themoviedatabase.di.configuration

import com.mikyegresl.themoviedatabase.business.configuration.*
import com.mikyegresl.themoviedatabase.business.configuration.ConfigurationEventBus
import com.mikyegresl.themoviedatabase.data.repository.ConfigurationRepository
import com.mikyegresl.themoviedatabase.data.repository.IConfigurationRepository
import com.mikyegresl.themoviedatabase.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ConfigurationScope

@ConfigurationScope
@Subcomponent(modules = [ConfigurationModule::class])
interface ConfigurationComponent {

    fun inject(activity: MainActivity)
}

@Module
interface ConfigurationModule {

    @ConfigurationScope
    @Binds
    fun bindRepository(repository: ConfigurationRepository): IConfigurationRepository

    @ConfigurationScope
    @Binds
    fun bindInteractor(interactor: ConfigurationInteractor): IConfigurationInteractor

    @ConfigurationScope
    @Binds
    fun bindConverter(converter: ConfigurationConverter): IConfigurationConverter

    @ConfigurationScope
    @Binds
    fun bindEventBus(eventBus: ConfigurationEventBus): IConfigurationEventBus
}