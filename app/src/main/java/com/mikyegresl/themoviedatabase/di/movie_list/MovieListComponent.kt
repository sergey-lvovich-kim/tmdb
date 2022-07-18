package com.mikyegresl.themoviedatabase.di.movie_list

import com.mikyegresl.themoviedatabase.business.configuration.*
import com.mikyegresl.themoviedatabase.business.movie_list.*
import com.mikyegresl.themoviedatabase.ui.movie_list.IMovieListPresenter
import com.mikyegresl.themoviedatabase.ui.movie_list.MovieListFragment
import com.mikyegresl.themoviedatabase.ui.movie_list.MovieListPresenter
import com.mikyegresl.themoviedatabase.ui.navigation.IMovieListRouter
import com.mikyegresl.themoviedatabase.ui.navigation.MovieListRouter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulers
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import dagger.*
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class MovieListScope

@MovieListScope
@Subcomponent(modules = [MovieListModule::class])
interface MovieListComponent {

    fun inject(fragment: MovieListFragment)
    fun presenter(): IMovieListPresenter
}

@Module
internal interface MovieListModule {

    @MovieListScope
    @Binds
    fun bindConfigurationInteractor(interactor: ConfigurationInteractor): IConfigurationInteractor

    @MovieListScope
    @Binds
    fun bindConfigurationConverter(converter: ConfigurationConverter): IConfigurationConverter

    @MovieListScope
    @Binds
    fun bindConfigurationEventBus(eventBus: ConfigurationEventBus): IConfigurationEventBus

    @MovieListScope
    @Binds
    fun bindMovieListInteractor(interactor: MovieListInteractor): IMovieListInteractor

    @MovieListScope
    @Binds
    fun bindMovieListConverter(converter: MovieListConverter): IMovieListConverter

    @MovieListScope
    @Binds
    fun bindRxTransformer(transformer: RxSchedulers): RxSchedulersTransformer

    @MovieListScope
    @Binds
    fun bindMovieListPresenter(impl: MovieListPresenter): IMovieListPresenter

    @MovieListScope
    @Binds
    fun bindMovieListRouter(impl: MovieListRouter): IMovieListRouter
}