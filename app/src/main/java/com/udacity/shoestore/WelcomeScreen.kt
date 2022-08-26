package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_welcome_screen.view.*


class WelcomeScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=inflater.inflate(R.layout.fragment_welcome_screen, container, false)
        binding.GoButton.setOnClickListener { it.findNavController().navigate(WelcomeScreenDirections.actionWelcomeScreenToInstructionScreen())
        }

        return binding
    }


}