package com.mikyegresl.themoviedatabase.di

import android.app.Application
import com.mikyegresl.themoviedatabase.di.application.AppComponent
import com.mikyegresl.themoviedatabase.di.application.AppModule
import com.mikyegresl.themoviedatabase.di.application.DaggerAppComponent

object ComponentManager {

    private var appComponent: AppComponent? = null

    internal fun plusAppComponent() =
        DaggerAppComponent
            .builder()
            .build()
            .also {
                appComponent = it
            }

    internal fun clearAppComponent() {
        appComponent = null
    }

//    internal fun plusTmdbComponent(): TmdbComponent =
//        tmdbComponent ?: appComponent.tmdbComponent()
//            .also { tmdbComponent = it }
//
//    internal fun clearTmdbComponent() {
//        tmdbComponent = null
//    }
}