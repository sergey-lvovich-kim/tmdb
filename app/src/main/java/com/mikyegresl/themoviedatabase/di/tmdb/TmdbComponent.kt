package com.mikyegresl.themoviedatabase.di.tmdb

import com.mikyegresl.themoviedatabase.business.configuration.*
import com.mikyegresl.themoviedatabase.business.tmdb.ITmdbConverter
import com.mikyegresl.themoviedatabase.business.tmdb.ITmdbInteractor
import com.mikyegresl.themoviedatabase.business.tmdb.TmdbConverter
import com.mikyegresl.themoviedatabase.business.tmdb.TmdbInteractor
import com.mikyegresl.themoviedatabase.data.repository.ConfigurationRepository
import com.mikyegresl.themoviedatabase.data.repository.IConfigurationRepository
import com.mikyegresl.themoviedatabase.data.repository.ITmdbRepository
import com.mikyegresl.themoviedatabase.data.repository.TmdbRepository
import com.mikyegresl.themoviedatabase.ui.tmdb.ITmdbPresenter
import com.mikyegresl.themoviedatabase.ui.tmdb.TmdbFragment
import com.mikyegresl.themoviedatabase.ui.tmdb.TmdbPresenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulers
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class TmdbScope

@TmdbScope
@Subcomponent(modules = [TmdbModule::class])
interface TmdbComponent {

    fun inject(fragment: TmdbFragment)
}

@Module
internal interface TmdbModule {

    @TmdbScope
    @Binds
    fun bindConfigurationRepository(repository: ConfigurationRepository): IConfigurationRepository

    @TmdbScope
    @Binds
    fun bindConfigurationInteractor(interactor: ConfigurationInteractor): IConfigurationInteractor

    @TmdbScope
    @Binds
    fun bindConfigurationConverter(converter: ConfigurationConverter): IConfigurationConverter

    @TmdbScope
    @Binds
    fun bindConfigurationEventBus(eventBus: ConfigurationEventBus): IConfigurationEventBus

    @TmdbScope
    @Binds
    fun bindRepository(repository: TmdbRepository): ITmdbRepository

    @TmdbScope
    @Binds
    fun bindInteractor(interactor: TmdbInteractor): ITmdbInteractor

    @TmdbScope
    @Binds
    fun bindConverter(converter: TmdbConverter): ITmdbConverter

    @TmdbScope
    @Binds
    fun bindRxTransformer(transformer: RxSchedulers): RxSchedulersTransformer

    @TmdbScope
    @Binds
    fun bindPresenter(impl: TmdbPresenter): ITmdbPresenter
}