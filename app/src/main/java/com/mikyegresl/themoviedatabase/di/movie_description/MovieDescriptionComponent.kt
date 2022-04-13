//package com.mikyegresl.themoviedatabase.di.movie_description
//
//import dagger.Binds
//import dagger.Module
//import dagger.Subcomponent
//import javax.inject.Scope
//
//@Scope
//@Retention(AnnotationRetention.RUNTIME)
//internal annotation class MovieDescriptionScope
//
//@MovieDescriptionScope
//@Subcomponent
//internal interface MovieDescriptionComponent {
//
//    fun inject(fragment: MovieDescriptionFragment)
//}
//
//@Module
//internal interface MovieDescriptionModule {
//
//    @Binds
//    fun bindPresenter(impl: MovieDescriptionPresenter): IMovieDescriptionPresenter
//
//    @Binds
//    fun bindInteractor(impl: MovieDescriptionInteractor): IMovieDescriptionInteractor
//}