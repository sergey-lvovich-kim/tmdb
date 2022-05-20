package com.mikyegresl.themoviedatabase.ui.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

abstract class TmdbNavigator(
    private val fragmentManager: FragmentManager
) {

    protected fun addFragment(@IdRes containerId: Int, fragment: Fragment) {
//        fragmentManager.commit(allowStateLoss = true) {
////            setCustomAnimations()
////            addToBackStack(null)
//            add(containerId, fragment)
//        }
        fragmentManager.beginTransaction().add(containerId, fragment).commitAllowingStateLoss()
    }

    protected fun replaceFragment(@IdRes containerId: Int, fragment: Fragment) {
        fragmentManager
            .beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }

    abstract fun onBackPressed()
}