package com.mikyegresl.themoviedatabase.ui.tmdb

import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikyegresl.themoviedatabase.data.model.MovieModel
import com.mikyegresl.themoviedatabase.databinding.ItemMovieBinding

internal class MovieAdapter(onItemClick: (MovieModel) -> Unit): ListDelegationAdapter<List<MovieModel>>() {

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
//                binding.ivPoster = item.posterPath
            }
        }
}