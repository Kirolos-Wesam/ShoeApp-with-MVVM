package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoesViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var newShoeName = ""
    var newShoeSize = ""
    var newCompanyName = ""
    var newShoeDescription = ""

    init {
        _shoeList.value= mutableListOf()
    }
    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }
    fun resetNewShoe() {
        newShoeName = ""
        newShoeSize = ""
        newCompanyName = ""
        newShoeDescription = ""
    }
    fun addNewShoe(): Boolean {
        if (!ValiddateInputs()) return false
        addShoe(
            newShoeName,
            newShoeSize.toDouble(),
            newCompanyName,
            newShoeDescription
        )
        return true
    }
    private fun ValiddateInputs(): Boolean{

        if (newShoeName.isBlank() ||
            newCompanyName.isBlank() ||
            newShoeSize.isBlank() ||
            newShoeDescription.isBlank()){
            return false
        }

        return true
    }
}