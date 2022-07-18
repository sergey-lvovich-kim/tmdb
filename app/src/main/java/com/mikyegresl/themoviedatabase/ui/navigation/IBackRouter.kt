package com.mikyegresl.themoviedatabase.ui.navigation

import android.app.Activity

interface IBackRouter {

    fun bind(activity: Activity, hostFragmentId: Int)

    fun unbind()

    fun back()
}