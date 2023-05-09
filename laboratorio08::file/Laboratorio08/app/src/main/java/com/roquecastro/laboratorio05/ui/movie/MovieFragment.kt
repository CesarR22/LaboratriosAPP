package com.roquecastro.laboratorio05.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.roquecastro.laboratorio05.R
import com.roquecastro.laboratorio05.databinding.FragmentMovieBinding

class MovieFragment : Fragment() {


    private lateinit var binding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.factory
    }
    private var onBackPressedCallback: OnBackPressedCallback? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false)

        val movieName = arguments?.getString("movieName")
        val movieCategory = arguments?.getString("movieCat")
        val movieDescription = arguments?.getString("movieDesc")
        val movieQ = arguments?.getString("movieQ")

        binding.displayNameTextview.text = movieName
        binding.displayCatTextview.text = movieCategory
        binding.displayDescTextview.text = movieDescription
        binding.displayQualiTextview.text = movieQ

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