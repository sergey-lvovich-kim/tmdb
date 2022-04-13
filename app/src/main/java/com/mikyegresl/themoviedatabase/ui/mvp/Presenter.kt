package com.mikyegresl.themoviedatabase.ui.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<T: IView>: IPresenter<T> {
    protected var view: T? = null
    protected var compositeDisposable = CompositeDisposable()

    override fun bindView(view: T) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onViewReady() {
        //base implementation
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    protected operator fun CompositeDisposable.plusAssign(subscribe: Disposable) {
        this.add(subscribe)
    }

    protected operator fun CompositeDisposable.minusAssign(unsubscribe: Disposable) {
        this.remove(unsubscribe)
    }
}