package com.mikyegresl.themoviedatabase.ui.movie_list

import com.bumptech.glide.Glide
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.mikyegresl.themoviedatabase.data.model.response.MovieListResponseModel
import com.mikyegresl.themoviedatabase.databinding.ItemMovieBinding
import com.mikyegresl.themoviedatabase.utils.Constants

internal class MovieListAdapter(
    onItemClick: (MovieListResponseModel) -> Unit,
): ListDelegationAdapter<List<MovieListResponseModel>>() {

    init {
        delegatesManager.addDelegate(createAdapterDelegate(onItemClick))
    }

    private fun createAdapterDelegate(onItemClick: (MovieListResponseModel) -> Unit): AdapterDelegate<List<MovieListResponseModel>> =
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
//                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.ivPoster)
            }
        }
}