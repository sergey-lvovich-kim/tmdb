package com.mikyegresl.themoviedatabase.ui.common.fragment

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layoutRes: Int): Fragment(layoutRes) {

//    protected val tmdbComponent: TmdbComponent by lazy {
//        (requireActivity() as BaseActivity).appComponent.tmdbComponent()
//    }
}