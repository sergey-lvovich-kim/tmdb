package com.mikyegresl.themoviedatabase.utils.rx

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class Rx2EventBus<T> {
    var value: T? = null
        private set

    private val subject: PublishSubject<T> = PublishSubject.create()

    private val observer = Observable.create<T> { source ->
        val subscribe = subject.subscribe { source.onNext(it!!) }
        source.setCancellable { subscribe.dispose() }
        handle()
    }

    private fun handle() {
        value?.let {
            subject.onNext(it)
            value = null
        }
    }

    fun listen(): Observable<T> = observer

    fun onNext(v: T) {
        value = v

        if (subject.hasObservers()) {
            handle()
        }
    }

    fun clear() {
        value = null
    }

    fun getValueAndClear(): T? {
        val result = value
        value = null
        return result
    }

    fun hasValue() = value != null
}