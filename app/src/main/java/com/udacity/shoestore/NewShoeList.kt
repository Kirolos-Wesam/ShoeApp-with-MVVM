package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.databinding.FragmentNewShoeListBinding


class NewShoeList : Fragment() {

    private val viewModel: ShoesViewModel by activityViewModels()
    private val binding by lazy {
        FragmentNewShoeListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.resetNewShoe()
        binding.viewModel = viewModel
        binding.AddButton.setOnClickListener {
            if (viewModel.addNewShoe()) {
                it.findNavController().navigate(
                    NewShoeListDirections.actionNewShoeListToShoesList()
                )
            }
            else{
                Toast.makeText(activity,"please enter all fields", Toast.LENGTH_LONG).show()
            }

            binding.CancelButton.setOnClickListener {
                it.findNavController().navigate(
                    NewShoeListDirections.actionNewShoeListToShoesList()
                )
            }

        }
        return binding.root
    }
}


