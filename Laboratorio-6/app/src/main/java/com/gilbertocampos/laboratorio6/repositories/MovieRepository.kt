package com.gilbertocampos.laboratorio6.repositories

import com.gilbertocampos.laboratorio6.models.Movie

class MovieRepository(private var movieList: MutableList<Movie>) {
    fun getMovies() : MutableList<Movie> {
        return  movieList
    }

    fun addNewMovie(movie: Movie) {
        movieList.add(movie)
    }
}