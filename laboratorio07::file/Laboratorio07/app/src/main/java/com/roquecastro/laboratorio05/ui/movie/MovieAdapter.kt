package com.roquecastro.laboratorio05.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roquecastro.laboratorio05.R
import com.roquecastro.laboratorio05.data.model.MovieModel

class MovieAdapter(private val onClickMoovie: (MovieModel) -> Unit) : RecyclerView.Adapter<MovieAdapter.ViewHolderMovie>() {

    private var movies: List<MovieModel>? = null

    class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieModel, onClickMovie: (MovieModel) -> Unit ) {
            val titleTextView: TextView = itemView.findViewById(R.id.movie_title)
            val qualiTextView: TextView = itemView.findViewById(R.id.movie_quali)
            titleTextView.text = movie.name
            qualiTextView.text = movie.qualification
            titleTextView.setOnClickListener {
                onClickMovie(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolderMovie(view)
    }

    override fun getItemCount(): Int = movies?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        movies?.let {
            holder.bind(it[position], onClickMoovie)
        }
    }

    fun submitData(movies: List<MovieModel>){
        this.movies = movies
    }



}