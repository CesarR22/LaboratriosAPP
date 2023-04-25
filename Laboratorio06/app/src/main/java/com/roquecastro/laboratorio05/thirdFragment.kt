package com.roquecastro.laboratorio05

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.roquecastro.laboratorio05.ui.movie.MovieViewModel

class ThirdFragment : Fragment() {
    private val movieViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }
    private var onBackPressedCallback: OnBackPressedCallback? = null
    private lateinit var nameEditText: EditText
    private lateinit var categoryEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var qualificationEditText: EditText
    private lateinit var submitbutton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)

        // Habilitar el callback de onBackPressed
        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Navegar a SecondFragment utilizando la acción correspondiente
                findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            onBackPressedCallback as OnBackPressedCallback
        )

        // Obtener referencias a los elementos visuales
        nameEditText = view.findViewById(R.id.InName)
        categoryEditText = view.findViewById(R.id.InCategory)
        descriptionEditText = view.findViewById(R.id.InDescription)
        qualificationEditText = view.findViewById(R.id.InQualification)
        submitbutton = view.findViewById(R.id.submit)

        // Configurar el botón de envío
        submitbutton.setOnClickListener {
            val name = nameEditText.text.toString()
            val category = categoryEditText.text.toString()
            val description = descriptionEditText.text.toString()
            val qualification = qualificationEditText.text.toString()

            // Crear un Bundle con los datos ingresados
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("category", category)
            bundle.putString("description", description)
            bundle.putString("qualification", qualification)

            // Navegar al FirstFragment con el Bundle de datos
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment, bundle)
            Log.d("NewMovieFragment", MovieViewModel.getMovies().toString())
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Remover el callback de onBackPressed al destruir la vista del fragmento
        onBackPressedCallback?.remove()
    }
}


