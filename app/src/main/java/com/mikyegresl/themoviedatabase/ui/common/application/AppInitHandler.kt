package com.mikyegresl.themoviedatabase.ui.common.application

import android.app.Activity

interface AppInitHandler {
    fun setAppInitialized()
    fun shouldReInitializeApp(currentActivity: Activity): Boolean
    fun reInitializeApp()
    fun reInitializeAppAndOpenSecurityScreen(sourceActivity: Activity?)
}