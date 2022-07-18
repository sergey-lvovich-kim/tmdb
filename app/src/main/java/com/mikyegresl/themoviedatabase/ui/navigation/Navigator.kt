package com.mikyegresl.themoviedatabase.ui.navigation

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.mikyegresl.themoviedatabase.ui.navigation.direction.Direction
import com.mikyegresl.themoviedatabase.ui.navigation.direction.NavControllerDirection
import javax.inject.Inject

class Navigator @Inject constructor(): INavigator {
    private var activity: Activity? = null
    private var hostFragmentId: Int = 0

    @Synchronized
    override fun navigate(direction: Direction) {
        if (direction is NavControllerDirection) {
            findNavController(hostFragmentId)?.let { navController ->
                direction.navigate(navController)
            }
        }
    }

    private fun findNavController(hostFragmentId: Int): NavController? =
         activity?.findNavController(hostFragmentId)

    @Synchronized
    override fun bind(activity: Activity, id: Int) {
        this.activity = activity
        hostFragmentId = id
    }

    override fun unbind() {
        this.activity = null
        this.hostFragmentId = 0
    }
}