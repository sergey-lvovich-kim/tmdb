package com.mikyegresl.themoviedatabase.ui

import android.os.Bundle
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.di.activity.ActivityComponent
import com.mikyegresl.themoviedatabase.di.application.AppComponent
import com.mikyegresl.themoviedatabase.di.configuration.ConfigurationComponent
import com.mikyegresl.themoviedatabase.ui.application.TmdbApp

class MainActivity : BaseActivity() {

    private val appComponent: AppComponent by lazy {
        (application as TmdbApp).appComponent
    }

    val activityComponent: ActivityComponent by lazy {
        appComponent.activityComponent()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}