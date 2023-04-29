package com.gilbertocampos.laboratorio6.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.gilbertocampos.laboratorio6.R
import com.gilbertocampos.laboratorio6.models.Movie
import com.gilbertocampos.laboratorio6.viewmodels.MovieViewModel
import com.google.android.material.textfield.TextInputEditText

class NewMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels { MovieViewModel.Factory }
    private lateinit var name: TextInputEditText
    private lateinit var category: TextInputEditText
    private lateinit var description: TextInputEditText
    private lateinit var qualification: TextInputEditText
    private lateinit var submit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        listeners()
    }

    private fun bind(view: View) {
        name = view.findViewById(R.id.editText_name)
        category = view.findViewById(R.id.editText_category)
        description = view.findViewById(R.id.editText_description)
        qualification = view.findViewById(R.id.editText_calification)
        submit = view.findViewById(R.id.submit_button)
    }

    private fun listeners() {
        submit.setOnClickListener {
            getMovieData()
            name.text?.clear()
            category.text?.clear()
            description.text?.clear()
            qualification.text?.clear()
        }
    }

    private fun getMovieData() {
        val nameText = name.text.toString()
        val categoryText = category.text.toString()
        val descriptionText = category.text.toString()
        val qualificationText = qualification.text.toString()

        viewModel.addNewMovie(Movie(nameText, categoryText, descriptionText, qualificationText))
        Log.d("NewMovie", viewModel.getMovies().toString())
    }

}