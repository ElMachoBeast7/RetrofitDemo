package com.example.shoppingappdemo

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingappdemo.data.Shopper
import com.example.shoppingappdemo.data.ShopperViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_list.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddFragment : Fragment() {

//    private lateinit var myShopperViewModel: ShopperViewModel
    lateinit var shoppingService: ShoppingService

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        view.addToCart.setOnClickListener{
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val item = addItem_et.text.toString()
        val price = addPrice_et.text.toString()
        val image = "";

        shoppingService = (requireActivity() as MainActivity).shoppingService

        if(inputCheck(item, price)){
            val shopper = Shopper(0, item, Integer.parseInt(price.toString()), image)

            Toast.makeText(requireContext(), "Successfully Added an Item!", Toast.LENGTH_LONG).show()
            shoppingService.create(shopper)

                .enqueue(object: Callback<Message> {
                    override fun onResponse(call: Call<Message>, response: Response<Message>) {
                        findNavController().navigate(R.id.action_addFragment_to_listFragment)
                    }

                    override fun onFailure(call: Call<Message>, t: Throwable) {

                    }
                })


        }else {
            Toast.makeText(requireContext(), "Invalid Item", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(item: String, price: String): Boolean {
        return !(TextUtils.isEmpty(item) && price.isEmpty())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}