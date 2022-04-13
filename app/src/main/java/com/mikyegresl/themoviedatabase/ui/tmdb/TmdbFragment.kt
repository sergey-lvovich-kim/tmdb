package com.mikyegresl.themoviedatabase.ui.tmdb

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.databinding.FragmentTmdbBinding
import com.mikyegresl.themoviedatabase.di.tmdb.TmdbComponent
import com.mikyegresl.themoviedatabase.ui.BaseFragment
import com.mikyegresl.themoviedatabase.ui.MainActivity
import javax.inject.Inject

class TmdbFragment: BaseFragment(R.layout.fragment_tmdb), ITmdbView {

    private lateinit var binding: FragmentTmdbBinding

    private val tmdbComponent: TmdbComponent by lazy {
        (requireActivity() as MainActivity).appComponent.tmdbComponent()
    }

    @Inject
    lateinit var presenter: ITmdbPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tmdbComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTmdbBinding.inflate(inflater, container, false)

        with (binding) {
            binding.rvTopRated.adapter =

            srlLoading.setOnRefreshListener {

            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewReady()
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
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showLoading() {
        binding.srlLoading.isRefreshing = true
    }

    override fun hideLoading() {
        binding.srlLoading.isRefreshing = false
    }

    override fun showError(message: String) {
        Log.e(TAG, message)
    }

    override fun showEmptyView() {

    }

    override fun showTopRated(topRated: List<MovieModel>) {

    }

    override fun showRecent(recent: List<MovieModel>) {

    }

    override fun onMovieClicked() {

    }

    override fun addToFavorites() {

    }

    override fun goToFavorites() {
    }

    override fun goToSearch() {
    }

    override fun exit() {
    }
}

private val TAG = TmdbFragment::javaClass.name