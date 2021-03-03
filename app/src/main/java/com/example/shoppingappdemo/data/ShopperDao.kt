package com.example.shoppingappdemo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopperDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addShopper(shooper: Shopper)

    @Query("SELECT * FROM shopping_table ORDER BY id ASC")
    fun readAllShoppingData(): LiveData<List<Shopper>>
}