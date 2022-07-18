package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.BackdropResponseModel
import com.mikyegresl.themoviedatabase.data.model.response.movie_details.*
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
//import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieCreditsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
import com.mikyegresl.themoviedatabase.utils.Constants.EMPTY_STRING
import javax.inject.Inject

class MovieDetailsConverter @Inject constructor(): IMovieDetailsConverter {

    private fun mapPoster(poster: BackdropResponseModel): MovieImageUiModel =
        MovieImageUiModel(
            height = poster.height,
            width = poster.width,
            filepath = poster.filepath,
            aspectRatio = poster.aspectRatio
        )

    private fun mapReleaseDate(releaseDate: String?): String =
        if (releaseDate.isNullOrEmpty() || releaseDate.length < 3) EMPTY_STRING
        else releaseDate.substring(0..3)

    private fun mapReview(review: MovieReviewResponseModel): MovieReviewUiModel =
        MovieReviewUiModel(
            id = review.id ?: EMPTY_STRING,
            username = review.authorDetailsResponseModel?.username ?: EMPTY_STRING,
            avatarPath = review.authorDetailsResponseModel?.username ?: EMPTY_STRING,
            content = review.content ?: EMPTY_STRING,
            reviewDate = review.updatedAt ?: EMPTY_STRING,
        )

    override fun movieDetailsResponseToUi(model: MovieDetailsResponseModel): MovieDetailsUiModel? {
        if (model.id == null || model.title.isNullOrEmpty() || model.overview.isNullOrEmpty()) {
            return null
        }
        return MovieDetailsUiModel(
            id = model.id,
            title = model.title,
            originalTitle = model.originalTitle ?: EMPTY_STRING,
            overview = model.overview,
            releaseDate = mapReleaseDate(model.releaseDate),
            popularity = model.popularity ?: 0.0f,
            voteAverage = model.voteAverage ?: 0.0f,
            voteCount = model.voteCount ?: 0,
            posterPath = model.posterPath ?: EMPTY_STRING,
            backdropPath = model.backdropPath ?: EMPTY_STRING,
            budget = model.budget ?: 0,
            revenue = model.revenue ?: 0,
            runtime = model.runtime ?: 0,
            isAdultContent = model.isAdultContent ?: false,
            genre = model.genres?.get(0)?.name ?: EMPTY_STRING,
            country = model.productionCountries?.get(0)?.name ?: EMPTY_STRING,
            productionCompany = model.productionCompanies?.get(0)?.name ?: EMPTY_STRING
        )
    }

    override fun movieImagesResponseToUi(model: MovieImagesResponseModel): List<MovieImageUiModel> =
        model.backdropResponseModels.map {
            mapPoster(it)
        }

    override fun movieReviewsResponseToUi(model: MovieReviewsResponseModel): List<MovieReviewUiModel> =
        model.reviews?.map { mapReview(it) } ?: emptyList()

//    override fun movieCreditsResponseToUi(model: MovieCreditsResponseModel): MovieCreditsUiModel {
//        TODO("Not yet implemented")
//    }

//    override fun watchProvidersResponseToUi(model: MovieWatchProvidersResponseModel): MovieWatchProvidersUiModel {
//        TODO("Not yet implemented")
//    }
}