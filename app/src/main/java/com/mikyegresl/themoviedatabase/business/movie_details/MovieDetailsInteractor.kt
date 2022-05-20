package com.mikyegresl.themoviedatabase.business.movie_details

import com.mikyegresl.themoviedatabase.data.repository.ITmdbRepository
import javax.inject.Inject

class MovieDetailsInteractor @Inject constructor(
    private val repository: ITmdbRepository
): IMovieDetailsInteractor {


}