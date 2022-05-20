package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.model.response.movie_details.MovieDetailsResponseModel
import com.mikyegresl.themoviedatabase.data.model.ui.MovieDetailsUiModel
import javax.inject.Inject

class MovieDetailsConverter @Inject constructor(): IMovieDetailsConverter {
    override fun detailsResponseToDetailsUi(model: MovieDetailsResponseModel): MovieDetailsUiModel =
        MovieDetailsUiModel(
            id = model.id,
            title = model.title,
            overview = model.overview,
            releaseDate = model.releaseDate,
            popularity = model.popularity,
            voteAverage = model.voteAverage,
            posterPath = model.posterPath,
            backdropPath = model.backdropPath,
            budget = model.budget,
            revenue = model.revenue,
            runtime = model.runtime,
            hasVideo = model.hasVideo,
            isAdultContent = model.isAdultContent,
            genres = model.genres.map { it.name },
            productionCountries = model.productionCountries.map { it.name },
            productionCompanies = model.productionCompanies.map { it.name },
        )
}