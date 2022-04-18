package com.mikyegresl.themoviedatabase.utils.ui

import android.os.Handler
import android.os.Looper
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.mikyegresl.themoviedatabase.ui.mvp.IPresenter
import com.mikyegresl.themoviedatabase.ui.mvp.IView
import com.mikyegresl.themoviedatabase.ui.mvp.Presenter
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/** Автоматически вызывает
* - [IPresenter.bindView]
* - [IPresenter.onViewReady]
* - [IPresenter.unbindView]
* - [IPresenter.onDestroy]
*
* согласно жизненному циклу [Fragment]
*
* НЕ вызывать самостоятельно [IPresenter.onViewReady],
* иначе будет задвоенный вызов [IPresenter.onViewReady]
*
* ВАЖНО! Так как метод [IPresenter.bindView] вызывается после [Fragment.onViewCreated]
* то при запуске метода MyPresenter.someMethod в [Fragment.onViewCreated],
* которому необходима view,
* ничего не отрисуется, так как view еще не готова.
*
* Если необходимо передать параметры в [IPresenter.onViewReady], то
* используйте EventBus или можно добавить метод MyPresenter.setMyParams(value)
* и вызвать его в [Fragment.onViewCreated]
*
*/
inline fun<V: IView, P: IPresenter<V>> Fragment.presenterBinding(
    crossinline vbFactory: () -> P
): FragmentPresenterLoader<V, P> = FragmentPresenterLoader(this) { vbFactory() }

/**
 * Прослойка для [ReadOnlyProperty] делегата,
 * чтобы был доступ к вызывающему классу view
 */
class FragmentPresenterLoader<in V: IView, out P: IPresenter<V>>(
    private val fragment: Fragment,
    private val viewBinder: () -> P
) {
    operator fun provideDelegate(
        view: V,
        prop: KProperty<*>
    ): ReadOnlyProperty<V, P> = LifecyclePresenterBindingProperty(view, fragment, viewBinder)
}

/**
 * Автоматически вызывает
 * - [IPresenter.bindView]
 * - [IPresenter.onViewReady]
 * - [IPresenter.unbindView]
 * - [IPresenter.onDestroy]
 *
 * согласно жизненному циклу [Fragment]
 */
class LifecyclePresenterBindingProperty<in V: IView, out P: IPresenter<V>>(
    view: V,
    private val fragment: Fragment,
    private val presenterBinder: () -> P,
): ReadOnlyProperty<V, P> {

    private var isViewAttached = false

    private val fragmentLifecycle: Lifecycle
        get() = fragment.lifecycle

    private val viewLifecycle: Lifecycle
        get() = fragment.viewLifecycleOwner.lifecycle

    private var presenter: P? = null

    init {
        fragmentLifecycle.addObserver(FragmentLifecycleObserver(view))
    }

    @MainThread
    override fun getValue(thisRef: V, property: KProperty<*>): P {
        return presenter ?: presenterBinder().also {
            this.presenter = it
        }
    }

    /*
     * Обработка жизненного цикла фрагмента
     */
    inner class FragmentLifecycleObserver(
        private val view: V,
    ) : LifecycleObserver {

        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            presenter = presenter ?: presenterBinder()
        }

        /**
         * Вызывается после создания фрагмента,
         * а так же после возвращения приложения из фона
         *
         * Поэтому стоит ограничение в виде проверки [isViewAttached],
         * чтобы, после возвращения приложения из фона,
         * небыло лишних вызововов
         * - [IPresenter.bindView]
         * - [IPresenter.onViewReady]
         *
         */
        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            if (isViewAttached.not()) {
                isViewAttached = true
                viewLifecycle.addObserver(ViewLifecycleObserver(view))
            }
        }

        /**
         * Вызывается перед [Fragment.onDestroy]
         */
        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            // Отложенное уничтожение presenter,
            // чтобы вызов был после [Fragment.onDestroy]
            mainHandler.post {
                fragmentLifecycle.removeObserver(this)
                presenter?.onDestroy()
                presenter = null
            }
        }

    }

    /*
     * Обработка жизненного цикла view у фрагмента
     */
    inner class ViewLifecycleObserver(
        private val view: V,
    ) : LifecycleObserver {

        /**
         * Вызывается после [Fragment.onViewCreated]
         */
        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            presenter?.bindView(view)
            presenter?.onViewReady()
        }

        /**
         * Вызывается перед [Fragment.onDestroyView]
         */
        @MainThread
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun onDestroy() {
            viewLifecycle.removeObserver(this)
            // Отложенная отписка от view,
            // чтобы вызов был после [Fragment.onDestroyView]
            mainHandler.post {
                presenter?.unbindView()
                isViewAttached = false
            }
        }

    }

    private companion object {

        private val mainHandler = Handler(Looper.getMainLooper())
    }
}