package com.mikyegresl.themoviedatabase.ui.movie_list

import androidx.annotation.VisibleForTesting
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationConverter
import com.mikyegresl.themoviedatabase.business.configuration.IConfigurationInteractor
import com.mikyegresl.themoviedatabase.business.movie_list.IMovieListInteractor
import com.mikyegresl.themoviedatabase.data.model.ui.configuration.ConfigurationUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_list.MovieListUiModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class MovieListPresenter @Inject constructor(
    private val configurationInteractor: IConfigurationInteractor,
    private val configurationConverter: IConfigurationConverter,
    private val movieListInteractor: IMovieListInteractor,
    private val rxSchedulersTransformer: RxSchedulersTransformer,

): Presenter<IMovieListView>(), IMovieListPresenter {
    @VisibleForTesting
    var configurationUi: ConfigurationUiModel? = null

    private var isViewActive: Boolean = false
    private var isConfigurationLoading: Boolean = false

    private fun loadConfigurationIfNeeded() {
        if (isConfigurationLoading)
            return
        configurationUi?.let { loadConfigurationSuccess(it) } ?: loadConfiguration()
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
            .subscribe(::loadConfigurationSuccess, ::loadConfigurationError)
    }

    private fun loadConfigurationSuccess(uiModel: ConfigurationUiModel) {
        configurationUi = uiModel
        view?.hideLoading()
    }

    private fun loadConfigurationError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    private fun loadTopRatedSuccess(topRated: List<MovieListUiModel>) {
        view?.showTopRated(topRated)
    }

    private fun loadTopRatedError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    private fun loadPopularSuccess(popular: List<MovieListUiModel>) {
        view?.showPopular(popular)
    }

    private fun loadPopularError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    private fun loadUpcomingSuccess(upcoming: List<MovieListUiModel>) {
        view?.showUpcoming(upcoming)
    }

    private fun loadUpcomingError(throwable: Throwable) {
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
            .subscribe(::loadTopRatedSuccess, ::loadTopRatedError)
    }

    override fun loadPopular() {
        compositeDisposable += movieListInteractor.getPopular()
            .compose(rxSchedulersTransformer.getIOToMainTransformer())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doFinally {
                view?.hideLoading()
            }
            .subscribe(::loadPopularSuccess, ::loadPopularError)
    }

    override fun loadUpcoming() {
        compositeDisposable += movieListInteractor.getUpcoming()
            .compose(rxSchedulersTransformer.getIOToMainTransformer())
            .doOnSubscribe {
                view?.showLoading()
            }
            .doFinally {
                view?.hideLoading()
            }
            .subscribe(::loadUpcomingSuccess, ::loadUpcomingError)
    }

    override fun onViewResume() {
        isViewActive = true

        loadConfigurationIfNeeded()
        loadTopRated()
        loadPopular()
        loadUpcoming()
    }

    override fun onViewPause() {
        isViewActive = false
    }
}