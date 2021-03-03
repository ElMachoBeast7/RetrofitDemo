package com.example.shoppingappdemo.data

import androidx.lifecycle.LiveData

class ShopperRepository(private val shopperDao: ShopperDao) {

    val readAllShoppingData: LiveData<List<Shopper>> = shopperDao.readAllShoppingData()

    suspend fun addShopper(shopper: Shopper){
        shopperDao.addShopper(shopper)
    }
}

