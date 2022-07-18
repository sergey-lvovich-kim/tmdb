package com.mikyegresl.themoviedatabase.ui.movie_details

import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsEventBus
import com.mikyegresl.themoviedatabase.business.movie_details.IMovieDetailsInteractor
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
import com.mikyegresl.themoviedatabase.ui.common.mvp.Presenter
import com.mikyegresl.themoviedatabase.utils.rx.RxSchedulersTransformer
import javax.inject.Inject

class MovieDetailsPresenter @Inject constructor(
    private val interactor: IMovieDetailsInteractor,
    private val eventBus: IMovieDetailsEventBus,
    private val rxSchedulersTransformer: RxSchedulersTransformer,
): Presenter<IMovieDetailsView>(), IMovieDetailsPresenter {

    private var movieId: Long? = null
    private var isViewActive: Boolean = false

    private fun loadDetailsSuccess(movieDetails: MovieDetailsUiModel) =
        view?.showMovieDetails(movieDetails)

    private fun loadDetailsError(throwable: Throwable) =
        view?.showError(throwable.message!!)

    private fun loadImagesSuccess(images: List<MovieImageUiModel>) =
        view?.showMovieImages(images)

    private fun loadImagesError(throwable: Throwable) =
        view?.showError(throwable.message!!)

    private fun loadReviewsSuccess(reviews: List<MovieReviewUiModel>) =
        view?.showMovieReviews(reviews)

    private fun loadReviewsError(throwable: Throwable) =
        view?.showError(throwable.message!!)

    override fun setMovieId(movieId: Long) {
        this.movieId = movieId
        eventBus.sendMovieId(movieId)
    }

    override fun loadMovieDetails() {
        movieId?.let {
            compositeDisposable += interactor.getMovieDetails(it)
                .compose(rxSchedulersTransformer.getIOToMainTransformer())
                .doOnSubscribe {
                    view?.showLoading()
                }
                .doFinally {
                    view?.hideLoading()
                }
                .subscribe(::loadDetailsSuccess, ::loadDetailsError)
        }
    }

    override fun loadMovieImages() {
        movieId?.let {
            compositeDisposable += interactor.getMovieImages(it)
                .compose(rxSchedulersTransformer.getIOToMainTransformer())
                .doOnSubscribe {
                    view?.showLoading()
                }
                .doFinally {
                    view?.hideLoading()
                }
                .subscribe(::loadImagesSuccess, ::loadImagesError)
        }
    }

    override fun loadMovieReviews() {
        movieId?.let {
            compositeDisposable += interactor.getMovieReviews(it)
                .compose(rxSchedulersTransformer.getIOToMainTransformer())
                .doOnSubscribe {
                    view?.showLoading()
                }
                .doFinally {
                    view?.hideLoading()
                }
                .subscribe(::loadReviewsSuccess, ::loadReviewsError)
        }
    }

    override fun onViewResume() {
        isViewActive = true

        compositeDisposable += eventBus.listenMovieId().subscribe(
            {
                loadMovieDetails()
            },
            {
                loadDetailsError(it)
            }
        )
    }

    override fun onViewPause() {
        isViewActive = false
    }
}

private val TAG = MovieDetailsPresenter::class.simpleName