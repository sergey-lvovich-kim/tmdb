package com.mikyegresl.themoviedatabase.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.mikyegresl.themoviedatabase.di.tmdb.TmdbComponent

abstract class BaseFragment(@LayoutRes layoutRes: Int): Fragment(layoutRes) {

//    protected val tmdbComponent: TmdbComponent by lazy {
//        (requireActivity() as BaseActivity).appComponent.tmdbComponent()
//    }
}