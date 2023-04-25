package com.roquecastro.laboratorio05.ui.movie

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.roquecastro.laboratorio05.Repositories.MovieRepository
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.ui.MovieReviewerApplication

class MovieViewModel(private val repository: MovieRepository):ViewModel() {

    fun getMovies() = repository.getMovies()

    fun addMovies( movie:MovieModel)= repository.addMovies(movie)

    companion object{
        val factory = viewModelFactory {
            initializer {
                val app =this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}