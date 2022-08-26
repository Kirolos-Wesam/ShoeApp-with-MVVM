package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import kotlinx.android.synthetic.main.fragment_company_name_text.view.*
import kotlinx.android.synthetic.main.fragment_description_text.view.*
import kotlinx.android.synthetic.main.fragment_shoe_name_text.view.*
import kotlinx.android.synthetic.main.fragment_shoe_size_text.view.*
import kotlinx.coroutines.internal.AddLastDesc


class ShoesList : Fragment() {

    private val viewModel: ShoesViewModel by activityViewModels()
    private val binding by lazy {FragmentShoesListBinding.inflate(layoutInflater)}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.ShoesList.removeAllViews()
            for (shoe in it) {
                AddShoeName(shoe.name)
                AddCompanyName(shoe.company)
                AddShoeSize(shoe.size)
                AddShoeDescription(shoe.description)

            }
        }

        binding.addShoeButton.setOnClickListener{
            it.findNavController().navigate(ShoesListDirections.actionShoesListToNewShoeList())
        }
        setHasOptionsMenu(true)
        return binding.root
    }


    private fun AddShoeName(ShoeName: String){
        val view=layoutInflater.inflate(R.layout.fragment_shoe_name_text,null)
        view.ShoeName.text=ShoeName
        binding.ShoesList.addView(view.ShoeName)

    }

    private fun AddCompanyName(CompanyName: String){
        val view=layoutInflater.inflate(R.layout.fragment_company_name_text,null)
        view.CompanyName.text=CompanyName
        binding.ShoesList.addView(view.CompanyName)

    }

    private fun AddShoeSize(ShoeSize: Double){
        val view=layoutInflater.inflate(R.layout.fragment_shoe_size_text,null)
        view.ShoeSize.text=ShoeSize.toString()
        binding.ShoesList.addView(view.ShoeSize)

    }
    private fun AddShoeDescription(Description: String){
        val view=layoutInflater.inflate(R.layout.fragment_description_text,null)
        view.Description.text=Description
        binding.ShoesList.addView(view.Description)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Logout_action ->
                findNavController().navigate(ShoesListDirections.actionShoesListToLoginScreen())
        }
        return super.onOptionsItemSelected(item)
    }
}