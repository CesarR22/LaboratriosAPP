package com.roquecastro.laboratorio05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.roquecastro.laboratorio05.R
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.databinding.FragmentNewMovieBinding

class NewMovieFragment : Fragment() {

    private lateinit var binding: FragmentNewMovieBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.factory
    }
    private var onBackPressedCallback: OnBackPressedCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_movie, container, false)
        binding.actionAddMovie.setOnClickListener {
            var movieName = binding.editTextMovieName.text.toString()
            var movieCat = binding.editTextMovieCat.text.toString()
            var movieDesc = binding.editTextMovieDesc.text.toString()
            var movieQ = binding.editTextMovieQual.text.toString()
            viewModel.addMovies(MovieModel(movieName,movieCat,movieDesc,movieQ))
            it.findNavController().navigateUp()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigateUp()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            onBackPressedCallback as OnBackPressedCallback
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onBackPressedCallback?.remove()
        onBackPressedCallback = null
    }

}