package com.mikyegresl.themoviedatabase.ui.navigation

import android.app.Activity
import androidx.annotation.IdRes
import com.mikyegresl.themoviedatabase.ui.navigation.direction.Direction

interface INavigator {

    fun navigate(direction: Direction)

    fun bind(activity: Activity, @IdRes id: Int)

    fun unbind()
}