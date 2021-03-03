package com.example.shoppingappdemo.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShopperViewModel(application: Application): AndroidViewModel(application) {

    val readAllShoppingData: LiveData<List<Shopper>>
    private val repository: ShopperRepository

    init{
        val shopperDao = ShopperDatabase.getDatabase(application).shopperDao()
        repository = ShopperRepository(shopperDao)
        readAllShoppingData = repository.readAllShoppingData
    }

    fun addShopper(shopper: Shopper) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addShopper(shopper)
        }
    }

}