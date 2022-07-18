package com.mikyegresl.themoviedatabase.ui.navigation.direction

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavDirections

interface Direction

interface NavControllerDirection : Direction {

    fun navigate(navController: NavController)
}

object NavigateBack : NavControllerDirection {

    override fun navigate(navController: NavController) {
        navController.popBackStack()
    }
}

abstract class NavGraphDirection(
    private val navDirections: NavDirections,
    private val args: Bundle? = null
) : NavControllerDirection {

    override fun navigate(navController: NavController) {
        val action = navController.currentDestination?.getAction(navDirections.actionId)
        if (action == null) {
            Log.i(
                "Navigation error",
                "Unknown directions $navDirections from current destination ${navController.currentDestination}"
            )
            return
        }

        if (args != null) {
            navController.navigate(navDirections.actionId, args)
        } else {
            navController.navigate(navDirections)
        }
    }
}