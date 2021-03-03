package com.example.shoppingappdemo.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "shopping_table")
data class Shopper(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val shoppingItem: String,
    val price: Int,
    val image: String
):Parcelable