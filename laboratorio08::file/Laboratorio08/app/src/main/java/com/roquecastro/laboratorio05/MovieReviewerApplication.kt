package com.roquecastro.laboratorio05

import android.app.Application
import com.roquecastro.laboratorio05.data.movies
import com.roquecastro.laboratorio05.repositories.MovieRepository

class MovieReviewerApplication: Application() {

    val movieRepository: MovieRepository by lazy{
        MovieRepository(movies)
    }

}