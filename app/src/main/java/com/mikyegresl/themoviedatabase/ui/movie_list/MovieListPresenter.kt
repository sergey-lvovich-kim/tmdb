package com.mikyegresl.themoviedatabase.ui.movie_list

import android.util.Log
import androidx.annotation.VisibleForTesting
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationConverter
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationInteractor
import com.mikyegresl.themoviedatabase.business.tmdb.IMovieListInteractor
import com.mikyegresl.themoviedatabase.data.model.ConfigurationModel
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.ui.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class MovieListPresenter @Inject constructor(
    private val configurationInteractor: IConfigurationInteractor,
    private val configurationConverter: IConfigurationConverter,
    private val movieListInteractor: IMovieListInteractor,
    private val rxSchedulersTransformer: RxSchedulersTransformer,
): Presenter<IMovieListView>(), IMovieListPresenter {

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

    override fun loadTopRated() {
        compositeDisposable += movieListInteractor.getTopRated()
            .compose(rxSchedulersTransformer.getIOToMainTransformer())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doFinally {
                view?.hideLoading()
            }
            .subscribe( { loadTopRatedSuccess(it) }, ::loadTopRatedError)
    }

    private fun loadTopRatedSuccess(topRated: List<MovieModel>) {
        Log.i(TAG, "loadTopRatedSuccess: $topRated")
        view?.showTopRated(topRated)
        view?.hideLoading()
    }

    private fun loadTopRatedError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    override fun loadRecent() {

    }

    override fun onViewResume() {
        isViewActive = true

        loadConfigurationIfNeeded()
        loadTopRated()
    }

    override fun onViewPause() {
        isViewActive = false
    }

    override fun onViewReady() {
        super.onViewReady()

        loadConfigurationIfNeeded()
        loadTopRated()
    }
}

private val TAG = MovieListPresenter::class.java.simpleName