package com.mikyegresl.themoviedatabase.di.movie_details

import com.mikyegresl.themoviedatabase.business.movie_details.*
import com.mikyegresl.themoviedatabase.ui.movie_details.IMovieDetailsPresenter
import com.mikyegresl.themoviedatabase.ui.movie_details.MovieDetailsFragment
import com.mikyegresl.themoviedatabase.ui.movie_details.MovieDetailsPresenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulers
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class MovieDetailsScope

@MovieDetailsScope
@Subcomponent(modules = [MovieDetailsModule::class])
interface MovieDetailsComponent {

    fun inject(fragment: MovieDetailsFragment)
    fun presenter(): IMovieDetailsPresenter
}

@Module
internal interface MovieDetailsModule {

    @MovieDetailsScope
    @Binds
    fun bindInteractor(impl: MovieDetailsInteractor): IMovieDetailsInteractor

    @MovieDetailsScope
    @Binds
    fun bindConverter(impl: MovieDetailsConverter): IMovieDetailsConverter

    @MovieDetailsScope
    @Binds
    fun bindEventBus(impl: MovieDetailsEventBus): IMovieDetailsEventBus

    @MovieDetailsScope
    @Binds
    fun bindRxTransformer(transformer: RxSchedulers): RxSchedulersTransformer

    @MovieDetailsScope
    @Binds
    fun bindPresenter(impl: MovieDetailsPresenter): IMovieDetailsPresenter
}