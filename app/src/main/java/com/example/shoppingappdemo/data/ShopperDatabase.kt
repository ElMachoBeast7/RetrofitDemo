package com.example.shoppingappdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Shopper::class], version = 1)
abstract class ShopperDatabase: RoomDatabase() {

    abstract fun shopperDao(): ShopperDao

    companion object{
        @Volatile
        private var SHOPINSTANCE: ShopperDatabase? = null

        fun getDatabase(context: Context): ShopperDatabase{
            val tempShopInstance = SHOPINSTANCE
            if(tempShopInstance != null) {
                return tempShopInstance
            }
            synchronized(this){
                val shopinstance = Room.databaseBuilder(
                    context.applicationContext,
                    ShopperDatabase::class.java,
                    "shopper_database"
                ).build()
                SHOPINSTANCE = shopinstance
                return shopinstance
            }
        }
    }
}