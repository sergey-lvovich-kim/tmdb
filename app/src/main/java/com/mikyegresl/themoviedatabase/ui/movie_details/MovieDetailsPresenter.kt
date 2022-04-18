package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsConverter
import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsEventBus
import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsInteractor
import com.mikyegresl.themoviedatabase.ui.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(
    private val interactor: IMovieDetailsInteractor,
    private val converter: IMovieDetailsConverter,
    private val eventBus: IMovieDetailsEventBus,
    private val rxSchedulersTransformer: RxSchedulersTransformer,
): Presenter<IMovieDesciptionView>(), IMovieDetailsPresenter {

    private var isViewActive: Boolean = false

    override fun loadGenres() {

    }

    override fun onViewResume() {
        isViewActive = true

        loadGenres()
    }

    override fun onViewPause() {
        isViewActive = false
    }

    override fun onViewReady() {
        super.onViewReady()

        loadGenres()
    }
}