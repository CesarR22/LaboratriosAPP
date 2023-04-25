package com.roquecastro.laboratorio05.ui

import android.app.Application
import com.roquecastro.laboratorio05.Repositories.MovieRepository
import movies

class MovieReviewerApplication:Application() {

    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}