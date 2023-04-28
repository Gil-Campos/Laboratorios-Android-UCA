package com.gilbertocampos.laboratorio6

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.gilbertocampos.laboratorio6.models.Movie
import com.gilbertocampos.laboratorio6.models.moviesDataBase
import com.gilbertocampos.laboratorio6.repositories.MovieRepository

class MovieViewModel(private var repository: MovieRepository) : ViewModel() {

    fun getMovies() : MutableList<Movie> {
        return  repository.getMovies()
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val repository = MovieRepository(moviesDataBase)
                MovieViewModel(repository)
            }
        }
    }
}