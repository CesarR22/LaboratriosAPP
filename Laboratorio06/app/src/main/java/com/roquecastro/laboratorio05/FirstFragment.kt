package com.roquecastro.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController


class FirstFragment : Fragment() {

    // Variables para guardar los datos recibidos del ThirdFragment
    private var name: String? = null
    private var category: String? = null
    private var description: String? = null
    private var qualification: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        view.findViewById<View>(R.id.floating_action_button)?.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        view.findViewById<View>(R.id.movie_card2)?.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener los datos del Bundle enviado desde el ThirdFragment
        arguments?.let {
            name = it.getString("name")
            category = it.getString("category")
            description = it.getString("description")
            qualification = it.getString("qualification")

            // Actualizar la interfaz de usuario con los datos recibidos
            // Puedes acceder a los elementos visuales de la vista mediante el objeto 'view'
            // Ejemplo: view.findViewById<TextView>(R.id.textViewNombre).text = name
        }
    }
}
