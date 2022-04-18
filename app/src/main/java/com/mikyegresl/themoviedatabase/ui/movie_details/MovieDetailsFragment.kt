package com.mikyegresl.themoviedatabase.ui.movie_details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.databinding.FragmentMovieDetailsBinding
import com.mikyegresl.themoviedatabase.di.movie_details.MovieDetailsComponent
import com.mikyegresl.themoviedatabase.ui.BaseFragment
import com.mikyegresl.themoviedatabase.ui.MainActivity
import com.mikyegresl.themoviedatabase.utils.ui.presenterBinding

class MovieDetailsFragment: BaseFragment(R.layout.fragment_movie_details), IMovieDesciptionView {

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

    override fun showError() {
        Log.e(TAG, "showError: ", )
    }

    override fun onBackPressed() {
        onBackPressed()
    }

    override fun onRefreshClicked() {
        presenter.loadGenres()
    }
}

private val TAG = MovieDetailsFragment::class.java.simpleName