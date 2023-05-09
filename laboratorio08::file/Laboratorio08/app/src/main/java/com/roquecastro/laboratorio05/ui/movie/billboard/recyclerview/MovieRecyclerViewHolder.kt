package com.roquecastro.laboratorio05.ui.movie.billboard.recyclerview


import androidx.recyclerview.widget.RecyclerView
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.databinding.ItemViewBinding

class MovieRecyclerViewHolder(private val binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: MovieModel, clickListener: (MovieModel)-> Unit){
        binding.movieTitle.text=movie.name
        binding.movieQuali.text=movie.qualification

        binding.movieCard.setOnClickListener{
            clickListener(movie)
        }
    }
}