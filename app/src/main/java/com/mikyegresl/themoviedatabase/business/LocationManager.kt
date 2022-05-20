package com.mikyegresl.themoviedatabase.business

import android.location.Location
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class LocationManager {
    private val locationSubject: Subject<Location> = PublishSubject.create()

    fun connect() {

    }
}