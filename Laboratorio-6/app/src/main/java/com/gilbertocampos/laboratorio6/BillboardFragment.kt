package com.gilbertocampos.laboratorio6

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillboardFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }
    private lateinit var seeMovie: CardView
    private lateinit var fabAddMovie: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        actions()
        Log.d("Movie", viewModel.getMovies().toString())
    }

    private fun bind(view: View) {
        fabAddMovie = view.findViewById(R.id.fabAddMovie)
        seeMovie = view.findViewById(R.id.star_wars_card)
    }

    private fun actions() {
        fabAddMovie.setOnClickListener {
            it.findNavController().navigate(R.id.newMovieFragment)
        }

        seeMovie.setOnClickListener {
            it.findNavController().navigate(R.id.movieFragment)
        }
    }
}