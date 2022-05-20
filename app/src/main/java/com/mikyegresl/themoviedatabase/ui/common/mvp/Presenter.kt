package com.mikyegresl.themoviedatabase.ui.common.mvp

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class Presenter<V: IView>: IPresenter<V> {
    protected var view: V? = null
    protected var compositeDisposable = CompositeDisposable()

    override fun bindView(view: V) {
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