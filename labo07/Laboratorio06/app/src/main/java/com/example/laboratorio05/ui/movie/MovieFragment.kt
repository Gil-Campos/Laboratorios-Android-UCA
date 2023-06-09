package com.example.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        displayMovie()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }

    private fun displayMovie() {
        binding.titleTextViewMovie.text = movieViewModel.name.value
        binding.typeTextViewMovie.text = movieViewModel.category.value
        binding.qualifTextViewMovie.text = movieViewModel.qualification.value
        binding.descTextViewMovie.text = movieViewModel.description.value
    }
}