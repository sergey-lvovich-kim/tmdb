package com.mikyegresl.themoviedatabase.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

//    protected val appComponent: AppComponent by lazy {
//        (application as TmdbApp).appComponent
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}