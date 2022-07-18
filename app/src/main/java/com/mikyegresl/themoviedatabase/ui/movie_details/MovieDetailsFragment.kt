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
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieDetailsUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieImageUiModel
import com.mikyegresl.themoviedatabase.data.model.ui.movie_details.MovieReviewUiModel
import com.mikyegresl.themoviedatabase.databinding.FragmentMovieDetailsBinding
import com.mikyegresl.themoviedatabase.di.movie_details.MovieDetailsComponent
import com.mikyegresl.themoviedatabase.ui.common.fragment.BaseFragment
import com.mikyegresl.themoviedatabase.ui.MainActivity
import com.mikyegresl.themoviedatabase.ui.navigation.IMovieDetailsRouter
import com.mikyegresl.themoviedatabase.ui.navigation.args.movieId
import com.mikyegresl.themoviedatabase.utils.Constants
import com.mikyegresl.themoviedatabase.utils.ui.presenterBinding
import javax.inject.Inject

class MovieDetailsFragment: BaseFragment(R.layout.fragment_movie_details), IMovieDetailsView {

    companion object {
        private const val ARG_MOVIE_ID = "movie_id"

        fun newInstance(movieId: Long): MovieDetailsFragment =
            MovieDetailsFragment().apply {
                arguments?.apply {
                    putLong(ARG_MOVIE_ID, movieId)
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

    @Inject
    lateinit var router: IMovieDetailsRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieDetailsComponent.inject(this)

        val movieId: Long = arguments?.movieId ?: 0
        presenter.setMovieId(movieId)
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

    override fun showMovieDetails(detailsModel: MovieDetailsUiModel) {
        with (binding) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                tvTitle.text = Html.fromHtml(detailsModel.title, Html.FROM_HTML_MODE_LEGACY)
                tvVote.text = Html.fromHtml(detailsModel.voteAverage.toString(), Html.FROM_HTML_MODE_LEGACY)
                tvVoteCount.text = Html.fromHtml(detailsModel.voteCount.toString(), Html.FROM_HTML_MODE_LEGACY)
                tvOriginalTitle.text = Html.fromHtml(detailsModel.originalTitle, Html.FROM_HTML_MODE_LEGACY)
                tvReleaseDate.text = Html.fromHtml(detailsModel.releaseDate, Html.FROM_HTML_MODE_LEGACY)
                tvGenres.text = Html.fromHtml(detailsModel.genre, Html.FROM_HTML_MODE_LEGACY)
                tvCountry.text = Html.fromHtml(detailsModel.country, Html.FROM_HTML_MODE_LEGACY)
                tvRuntime.text = Html.fromHtml(detailsModel.runtime.toString(), Html.FROM_HTML_MODE_LEGACY)
                tvBudget.text = Html.fromHtml(detailsModel.budget.toString(), Html.FROM_HTML_MODE_LEGACY)
                tvRevenue.text = Html.fromHtml(detailsModel.revenue.toString(), Html.FROM_HTML_MODE_LEGACY)
                tvOverview.text = Html.fromHtml(detailsModel.overview, Html.FROM_HTML_MODE_LEGACY)

            }
            else {
//                @Suppress("DEPRECATION")
//                tvTitle.text = Html.fromHtml(detailsModel.title)
//                @Suppress("DEPRECATION")
//                tvReleaseDate.text = Html.fromHtml(detailsModel.releaseDate)
//                @Suppress("DEPRECATION")
//                tvVote.text = Html.fromHtml(detailsModel.voteAverage)
//                @Suppress("DEPRECATION")
//                tvGenres.text = Html.fromHtml(model.genre)
//                @Suppress("DEPRECATION")
//                tvOverview.text = Html.fromHtml(detailsModel.overview)
            }

            Glide
                .with(requireContext())
                .load(Constants.TMDB_POSTER_URL + "original" + detailsModel.posterPath)
                .centerCrop()
//                    .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivPoster)

            Glide
                .with(requireContext())
                .load(Constants.TMDB_POSTER_URL + "original" + detailsModel.backdropPath)
                .centerCrop()
//                    .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivPoster)
        }
    }

    override fun showMovieImages(images: List<MovieImageUiModel>) {
        TODO("Not yet implemented")
    }

    override fun showMovieReviews(images: List<MovieReviewUiModel>) {
        TODO("Not yet implemented")
    }

    override fun onBackPressed() = router.back()

    override fun onRefreshClicked() = presenter.loadMovieDetails()
}

private val TAG = MovieDetailsFragment::class.java.simpleName