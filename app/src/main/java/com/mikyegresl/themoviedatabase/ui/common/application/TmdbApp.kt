package com.mikyegresl.themoviedatabase.ui.common.application

import android.app.Application
import com.mikyegresl.themoviedatabase.di.ComponentManager
import com.mikyegresl.themoviedatabase.di.application.AppComponent

class TmdbApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = ComponentManager.plusAppComponent()

    }
}