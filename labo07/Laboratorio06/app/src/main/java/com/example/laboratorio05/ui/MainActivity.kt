package com.example.laboratorio05.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.databinding.ActivityMainBinding
import com.example.laboratorio05.ui.movie.MovieViewModel

class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = movieViewModel
    }
}