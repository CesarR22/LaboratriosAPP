package com.roquecastro.laboratorio05.repositories

import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.data.name

class MovieRepository(private val movies: MutableList<MovieModel>) {

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}