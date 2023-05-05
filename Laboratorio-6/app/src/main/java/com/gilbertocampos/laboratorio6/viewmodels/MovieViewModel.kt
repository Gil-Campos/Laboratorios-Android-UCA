package com.gilbertocampos.laboratorio6.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.gilbertocampos.laboratorio6.models.Movie
import com.gilbertocampos.laboratorio6.models.moviesDataBase
import com.gilbertocampos.laboratorio6.repositories.MovieRepository

class MovieViewModel(private var repository: MovieRepository) : ViewModel() {

    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")


    fun getMovies() : MutableList<Movie> {
        return  repository.getMovies()
    }

    fun addNewMovie(movie: Movie) {
        repository.addNewMovie(movie)
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val repository = MovieRepository(moviesDataBase)
                MovieViewModel(repository)
            }
        }

        const val MOVIE_CREATED = "Movie created"
        const val WRONG_INFORMATION = "Wrong Information"
        const val INACTIVE = ""
    }
}