package com.mikyegresl.themoviedatabase.ui.movie_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.databinding.FragmentMovieListBinding
import com.mikyegresl.themoviedatabase.di.movie_list.MovieListComponent
import com.mikyegresl.themoviedatabase.ui.BaseFragment
import com.mikyegresl.themoviedatabase.ui.MainActivity
import com.mikyegresl.themoviedatabase.utils.ui.presenterBinding

class MovieListFragment: BaseFragment(R.layout.fragment_movie_list), IMovieListView {

    private lateinit var binding: FragmentMovieListBinding

    private val movieListComponent: MovieListComponent by lazy {
        (requireActivity() as MainActivity).activityComponent.movieListComponent()
    }

    private val presenter: IMovieListPresenter by presenterBinding {
        movieListComponent.presenter()
    }

    private val adapter: MovieListAdapter by lazy {
        MovieListAdapter(::onMovieClicked)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieListComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieListBinding.inflate(inflater, container, false)

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
        presenter.onDestroy()

        super.onDestroy()
    }

    override fun showLoading() {
        binding.srlRefresh.isRefreshing = true
    }

    override fun hideLoading() {
        binding.srlRefresh.isRefreshing = false
    }

    override fun showError(message: String) {
        Log.e(TAG, message)
    }

    override fun showEmptyView() {

    }

    override fun showTopRated(topRated: List<MovieModel>) {
        binding.rvTopRated.adapter = adapter.apply { items = topRated }
    }

    override fun showRecent(recent: List<MovieModel>) {

    }

    override fun onMovieClicked(movie: MovieModel) {
        //todo: implement details navigation
    }

    override fun onRefreshClicked() {
        presenter.loadTopRated()
        presenter.loadRecent()
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

private val TAG = MovieListFragment::class.java.simpleName