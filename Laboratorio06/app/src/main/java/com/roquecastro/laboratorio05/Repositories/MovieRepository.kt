package com.roquecastro.laboratorio05.Repositories

import com.roquecastro.laboratorio05.data.model.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel> ){

    fun getMovies() = movies

    fun addMovies(movie: MovieModel) = movies.add(movie)

}