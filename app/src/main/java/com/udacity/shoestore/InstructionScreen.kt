package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_instruction_screen.view.*


class InstructionScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= inflater.inflate(R.layout.fragment_instruction_screen, container, false)
        binding.NextButton.setOnClickListener {
            it.findNavController().navigate(InstructionScreenDirections.actionInstructionScreenToShoesList())
        }
        return binding
    }

}