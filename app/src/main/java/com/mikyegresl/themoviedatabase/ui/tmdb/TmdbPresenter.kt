package com.mikyegresl.themoviedatabase.ui.tmdb

import androidx.annotation.VisibleForTesting
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationConverter
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationInteractor
import com.mikyegresl.themoviedatabase.business.tmdb.ITmdbInteractor
import com.mikyegresl.themoviedatabase.data.model.ConfigurationModel
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.ui.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class TmdbPresenter @Inject constructor(
    private val configurationInteractor: IConfigurationInteractor,
    private val configurationConverter: IConfigurationConverter,
    private val tmdbInteractor: ITmdbInteractor,
    private val rxSchedulersTransformer: RxSchedulersTransformer,
): Presenter<ITmdbView>(), ITmdbPresenter {

    @VisibleForTesting
    var configuration: ConfigurationModel? = null

    private var isViewActive: Boolean = false
    private var isConfigurationLoading: Boolean = false

    private fun loadConfigurationIfNeeded() {
        if (isConfigurationLoading)
            return
        configuration?.let { loadConfigurationSuccess(it) } ?: loadConfiguration()
    }

    private fun loadConfiguration() {
        compositeDisposable += configurationInteractor.getConfiguration()
            .compose(rxSchedulersTransformer.getIOToMainTransformerSingle())
            .doOnSubscribe {
                isConfigurationLoading = true
                view?.showLoading()
            }
            .doFinally {
                isConfigurationLoading = false
                view?.hideLoading()
            }
            .map(configurationConverter::mapToConfigurationModel)
//            .doOnSuccess { model ->
//                event
//            }
            .subscribe(::loadConfigurationSuccess, ::loadConfigurationError)
    }

    private fun loadConfigurationSuccess(model: ConfigurationModel) {
        configuration = model
        view?.hideLoading()
    }

    private fun loadConfigurationError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    private fun loadTopRated() {
        compositeDisposable += tmdbInteractor.getTopRated()
            .compose(rxSchedulersTransformer.getIOToMainTransformer())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doFinally {
                view?.hideLoading()
            }
            .subscribe( { model ->
                loadTopRatedSuccess(model.movieList)
            }, ::loadTopRatedError)
    }

    private fun loadTopRatedSuccess(topRated: List<MovieModel>) {
        view?.showTopRated(topRated)
        view?.hideLoading()
    }

    private fun loadTopRatedError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    override fun onViewResume() {
        isViewActive = true
        loadConfigurationIfNeeded()
    }

    override fun onViewPause() {
        isViewActive = false
    }

    override fun onViewReady() {
        super.onViewReady()

        loadConfigurationIfNeeded()

    }
}

private val TAG = TmdbPresenter::class.java.simpleName