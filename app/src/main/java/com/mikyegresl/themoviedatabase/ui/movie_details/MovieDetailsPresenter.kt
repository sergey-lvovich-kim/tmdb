package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsConverter
import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsEventBus
import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsInteractor
import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(
    private val interactor: IMovieDetailsInteractor,
    private val converter: IMovieDetailsConverter,
    private val eventBus: IMovieDetailsEventBus,
    private val rxSchedulersTransformer: RxSchedulersTransformer,
): Presenter<IMovieDesciptionView>(), IMovieDetailsPresenter {

    private var movieListResponseDetails: MovieListResponseModel? = null
    private var isViewActive: Boolean = false

    private fun loadDetailsSuccess(listResponseModel: MovieListResponseModel) {
        view?.showMovieDetails(listResponseModel)
    }

    private fun loadDetailsError(throwable: Throwable) {
        view?.showError(throwable.message!!)
    }

    override fun loadGenres() {

    }

    override fun onViewResume() {
        isViewActive = true

        loadGenres()

        compositeDisposable += eventBus.listenMovieDetails()
            .subscribe(::loadDetailsSuccess, ::loadDetailsError)

    }

    override fun onViewPause() {
        isViewActive = false
    }
}

private val TAG = MovieDetailsPresenter::class.simpleName