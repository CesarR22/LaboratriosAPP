package com.roquecastro.laboratorio05.ui.movie.billboard.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.databinding.ItemViewBinding


class MovieRecyclerViewAdapater (private val clickListener: (MovieModel)-> Unit) : RecyclerView.Adapter<MovieRecyclerViewHolder>() {
        private val movies= ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int):MovieRecyclerViewHolder{
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie= movies[position]
        holder.bind(movie, clickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)
    }
}
