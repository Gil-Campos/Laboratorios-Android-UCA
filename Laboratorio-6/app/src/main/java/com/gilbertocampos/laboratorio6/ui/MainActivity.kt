package com.gilbertocampos.laboratorio6.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gilbertocampos.laboratorio6.R
import com.gilbertocampos.laboratorio6.viewmodels.MovieViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModels { MovieViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}