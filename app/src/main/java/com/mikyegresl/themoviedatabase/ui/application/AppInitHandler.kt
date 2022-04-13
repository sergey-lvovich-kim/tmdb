package com.mikyegresl.themoviedatabase.ui.application

import android.app.Activity

interface AppInitHandler {
    fun setAppInitialized()
    fun shouldReInitializeApp(currentActivity: Activity): Boolean
    fun reInitializeApp()
    fun reInitializeAppAndOpenSecurityScreen(sourceActivity: Activity?)
}