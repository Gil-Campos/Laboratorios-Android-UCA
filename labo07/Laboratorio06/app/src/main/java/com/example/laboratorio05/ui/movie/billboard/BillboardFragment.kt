package com.example.laboratorio05.ui.movie.billboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.model.MovieModel
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.example.laboratorio05.ui.movie.MovieViewModel
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter

class BillboardFragment : Fragment() {

    private lateinit var binding: FragmentBillboardBinding
    private lateinit var adapter: MovieRecyclerViewAdapter

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBillboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()

        setRecyclerView(view)

        binding.btnNavCreateNewMovie.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapter { selectedMovie -> showSelectedItem(selectedMovie) }
        binding.recyclerView.adapter = adapter
        displayMovies()
    }

    private fun showSelectedItem(movie: MovieModel) {
        movieViewModel.selectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }

    private fun displayMovies() {
        adapter.setData(movieViewModel.getMovies())
        Log.d("BILLBOARD_MOVIE", movieViewModel.getMovies().toString())
        adapter.notifyDataSetChanged()
    }
}