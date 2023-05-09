package com.roquecastro.laboratorio05.ui.movie.billboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.roquecastro.laboratorio05.R
import com.roquecastro.laboratorio05.data.model.MovieModel
import com.roquecastro.laboratorio05.databinding.FragmentBillboardBinding
import com.roquecastro.laboratorio05.ui.movie.MovieViewModel
import com.roquecastro.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapater

class BillboardFragment : Fragment() {

    private lateinit var adapter: MovieRecyclerViewAdapater

    private fun ShowSelectedItem(movie: MovieModel){
        viewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
    }
   private fun displayMovies(){
        adapter.setData(viewModel.getMovies())
        adapter.notifyDataSetChanged()
    }
    private fun setRecyclerView(view: View){
        binding.recylerViewMovies.layoutManager = LinearLayoutManager(view.context)
        adapter = MovieRecyclerViewAdapater { selectedMovie ->
            ShowSelectedItem(selectedMovie)
        }
        binding.recylerViewMovies.adapter = adapter
        displayMovies()
    }

    private lateinit var binding: FragmentBillboardBinding
    private val viewModel: MovieViewModel by viewModels {
        MovieViewModel.factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_billboard, container, false)
        binding.actionButtonAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val adapter = MovieRecyclerViewAdapater {
           val bundle = Bundle().apply {
               putString("movieName", it.name)
               putString("movieCat", it.category)
               putString("movieDesc", it.description)
               putString("movieQ", it.qualification)
           }
           findNavController().navigate(R.id.action_billboardFragment_to_movieFragment,bundle)
       }
        adapter.setData(viewModel.getMovies())
        binding.recylerViewMovies.adapter=adapter
        setRecyclerView(view)

        binding.actionButtonAdd.setOnClickListener{
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }
    }

    /**
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MovieAdapter {
            val bundle = Bundle().apply {
                putString("movieName", it.name)
                putString("movieCat", it.category)
                putString("movieDesc", it.description)
                putString("movieQ", it.qualification)
            }
            findNavController().navigate(R.id.action_billboardFragment_to_movieFragment, bundle)
        }
        adapter.submitData(viewModel.getMovies())

        binding.recylerViewMovies.adapter = adapter
    }
**/

}