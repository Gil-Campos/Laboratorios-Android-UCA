package com.gilbertocampos.laboratorio6.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.gilbertocampos.laboratorio6.R
import com.gilbertocampos.laboratorio6.models.Movie

class NewMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.addNewMovie(Movie("Some random", "Some random"))
        Log.d("NewMovie", viewModel.getMovies().toString())
    }

}