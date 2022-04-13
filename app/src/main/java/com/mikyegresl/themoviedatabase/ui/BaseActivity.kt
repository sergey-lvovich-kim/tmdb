package com.mikyegresl.themoviedatabase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mikyegresl.themoviedatabase.di.application.AppComponent
import com.mikyegresl.themoviedatabase.di.tmdb.TmdbComponent
import com.mikyegresl.themoviedatabase.ui.application.TmdbApp

abstract class BaseActivity: AppCompatActivity() {

//    protected val appComponent: AppComponent by lazy {
//        (application as TmdbApp).appComponent
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}