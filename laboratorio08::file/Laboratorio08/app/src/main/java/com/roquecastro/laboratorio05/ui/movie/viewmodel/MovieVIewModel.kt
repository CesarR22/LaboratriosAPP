package com.roquecastro.laboratorio05.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.roquecastro.laboratorio05.repositories.MovieRepository
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.MovieReviewerApplication

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMovies() = repository.getMovies()

    fun addMovies(movie: MovieModel) = repository.addMovies(movie)

    fun setSelectedMovie(movie: MovieModel){
        name.value = movie.name
        category.value = movie.category
        description.value= movie.description
        qualification.value= movie.qualification
    }

    companion object{
        val factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
        const val MOVIE_CREATED = "Movie Created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
        const val APP_TAG = "APP_TAG"
    }

    fun createMovie() {
        if(!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val movie = MovieModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addMovies(movie)
        clearData()

        status.value = MOVIE_CREATED
    }
     fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }
    fun clearStatus(){
        status.value = INACTIVE
    }
    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }



}