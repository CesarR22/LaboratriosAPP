package com.example.laboratorio09

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.corutinesdemo.R
import com.example.corutinesdemo.databinding.FragmentMainThreadBinding
import com.example.laboratorio09.MainActivity.Companion.APP_TAG


class MainThreadFragment : Fragment() {

    private var count = 0
    private lateinit var binding: FragmentMainThreadBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainThreadBinding.inflate(inflater, container, false)

        val view = inflater.inflate(R.layout.fragment_main_thread, container, false)

        // Habilitar el callback de onBackPressed
        var onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Navegar a home utilizando la acción correspondiente
                findNavController().navigate(R.id.action_main_to_home2)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            onBackPressedCallback as OnBackPressedCallback
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.counterButtonMt.setOnClickListener {
            binding.counterTextViewMt.text = count++.toString()
        }

        binding.downloadButtonMt.setOnClickListener {
            Toast.makeText(requireContext(), "Check your Logcat", Toast.LENGTH_SHORT).show()
            downloadUserData()
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            // This is running in main thread
            Log.i(APP_TAG, "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}



