package com.roquecastro.laboratorio05

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController

class ThirdFragment : Fragment() {
    private var onBackPressedCallback: OnBackPressedCallback? = null

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

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Remover el callback de onBackPressed al destruir la vista del fragmento
        onBackPressedCallback?.remove()
    }
}
