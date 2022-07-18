package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
import com.mikyegresl.themoviedatabase.data.repository.IMovieDetailsRepository
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieCreditsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieWatchProvidersUiModel
import io.reactivex.Observable
import javax.inject.Inject

class MovieDetailsInteractor @Inject constructor(
    private val repository: IMovieDetailsRepository,
    private val converter: IMovieDetailsConverter
): IMovieDetailsInteractor {
    override fun getMovieDetails(id: Long): Observable<MovieDetailsUiModel> =
        repository.getMovieDetails(id = id).map { movieDetails ->
            converter.movieDetailsResponseToUi(movieDetails)
        }

    override fun getMovieImages(id: Long): Observable<List<MovieImageUiModel>> =
        repository.getMovieImages(id = id).map { images ->
            converter.movieImagesResponseToUi(images)
        }

//    override fun getMovieCredits(id: Long): Observable<MovieCreditsUiModel> =
//        repository.getMovieCredits(id = id).map { credits ->
//            converter.movieCreditsResponseToUi(credits)
//        }

    //todo: do pagination
    override fun getMovieReviews(id: Long, page: Int): Observable<List<MovieReviewUiModel>> =
        repository.getMovieReviews(id = id, page = page).map { reviews ->
            converter.movieReviewsResponseToUi(reviews)
        }

//    override fun getMovieWatchProviders(id: Long): Observable<MovieWatchProvidersUiModel> =
//        repository.getMovieWatchProviders(id = id).map { providers ->
//            converter.watchProvidersResponseToUi(providers)
//        }
}