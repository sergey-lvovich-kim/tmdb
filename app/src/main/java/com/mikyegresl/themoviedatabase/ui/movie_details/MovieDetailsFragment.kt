package com.mikyegresl.themoviedatabase.ui.movie_details

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.databinding.FragmentMovieDetailsBinding
import com.mikyegresl.themoviedatabase.di.movie_details.MovieDetailsComponent
import com.mikyegresl.themoviedatabase.ui.common.fragment.BaseFragment
import com.mikyegresl.themoviedatabase.ui.MainActivity
import com.mikyegresl.themoviedatabase.utils.Constants
import com.mikyegresl.themoviedatabase.utils.ui.presenterBinding

class MovieDetailsFragment: BaseFragment(R.layout.fragment_movie_details), IMovieDesciptionView {

    companion object {
        private const val ARG_MOVIE = "movie"

        fun newInstance(movieListResponse: MovieListResponseModel): MovieDetailsFragment =
            MovieDetailsFragment().apply {
                arguments?.apply {
                    putParcelable(ARG_MOVIE, movieListResponse)
                }
            }
    }

    private lateinit var binding: FragmentMovieDetailsBinding

    private val movieDetailsComponent: MovieDetailsComponent by lazy {
        (requireActivity() as MainActivity).activityComponent.movieDetailsComponent()
    }

    private val presenter: IMovieDetailsPresenter by presenterBinding {
        movieDetailsComponent.presenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieDetailsComponent.inject(this)

        val movieListResponseModel: MovieListResponseModel? = arguments?.getParcelable(ARG_MOVIE) as? MovieListResponseModel
        Log.i(TAG, "onCreate: model=$movieListResponseModel")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)

        with (binding) {
            srlRefresh.setOnRefreshListener(::onRefreshClicked)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        presenter.onViewResume()
    }

    override fun onPause() {
        super.onPause()

        presenter.onViewPause()
    }

    override fun onDestroyView() {
        presenter.unbindView()

        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroy()
    }

    override fun showLoading() {
        binding.srlRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        binding.srlRefresh.isRefreshing = false
    }

    override fun showError(error: String) {
        Log.e(TAG, "showError: $error")
    }

    override fun showMovieDetails(listResponseModel: MovieListResponseModel) {
        with (binding) {
            with (binding) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    tvTitle.text = Html.fromHtml(listResponseModel.title, Html.FROM_HTML_MODE_LEGACY)
                    tvReleaseDate.text = Html.fromHtml(listResponseModel.releaseDate, Html.FROM_HTML_MODE_LEGACY)
                    tvVote.text = Html.fromHtml(listResponseModel.voteAverage, Html.FROM_HTML_MODE_LEGACY)
//                tvGenres.text = Html.fromHtml(model.genre, Html.FROM_HTML_MODE_LEGACY)
                    tvOverview.text = Html.fromHtml(listResponseModel.overview, Html.FROM_HTML_MODE_LEGACY)

                }
                else {
                    @Suppress("DEPRECATION")
                    tvTitle.text = Html.fromHtml(listResponseModel.title)
                    @Suppress("DEPRECATION")
                    tvReleaseDate.text = Html.fromHtml(listResponseModel.releaseDate)
                    @Suppress("DEPRECATION")
                    tvVote.text = Html.fromHtml(listResponseModel.voteAverage)
                    @Suppress("DEPRECATION")
//                tvGenres.text = Html.fromHtml(model.genre)
                    @Suppress("DEPRECATION")
                    tvOverview.text = Html.fromHtml(listResponseModel.overview)
                }

                Glide
                    .with(requireContext())
                    .load(Constants.TMDB_POSTER_URL + "w92" + listResponseModel.posterPath)
                    .centerCrop()
//                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivPoster)

                Glide
                    .with(requireContext())
                    .load(Constants.TMDB_POSTER_URL + "w92" + listResponseModel.backdropPath)
                    .centerCrop()
//                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivBackdrop)
            }
        }
    }

    override fun onBackPressed() {
        onBackPressed()
    }

    override fun onRefreshClicked() {
        presenter.loadGenres()
    }
}

private val TAG = MovieDetailsFragment::class.java.simpleName