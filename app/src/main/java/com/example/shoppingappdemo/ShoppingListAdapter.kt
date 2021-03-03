package com.example.shoppingappdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppingappdemo.data.Shopper
import kotlinx.android.synthetic.main.shopping_items_row.view.*

class ShoppingListAdapter: RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder>() {

    private var shopperList = emptyList<Shopper>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_items_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = shopperList[position]
        holder.itemView.item_txt.text = currentItem.shoppingItem
        holder.itemView.price_txt.text = currentItem.price.toString()

    }

    fun setData(user: List<Shopper>){
        this.shopperList = user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return shopperList.size
    }

}