package com.mikyegresl.themoviedatabase.ui.movie_list

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikyegresl.themoviedatabase.R
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.databinding.ItemMovieBinding
import com.mikyegresl.themoviedatabase.utils.Constants

internal class MovieListAdapter(onItemClick: (MovieModel) -> Unit): ListDelegationAdapter<List<MovieModel>>() {

    init {
        delegatesManager.addDelegate(createAdapterDelegate(onItemClick))
    }

    private fun createAdapterDelegate(onItemClick: (MovieModel) -> Unit): AdapterDelegate<List<MovieModel>> =
        adapterDelegateViewBinding(
            { inflater, parent -> ItemMovieBinding.inflate(inflater, parent, false) }
        ) {
            itemView.setOnClickListener { onItemClick(item) }

            bind {
                binding.tvTitle.text = item.title
                binding.tvReleaseDate.text = item.releaseDate

                Glide
                    .with(context)
                    .load(Constants.TMDB_POSTER_URL + "w92" + item.posterPath)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivPoster)
            }
        }
}