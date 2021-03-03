package com.example.shoppingappdemo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppingappdemo.data.ShopperViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import androidx.lifecycle.Observer
import com.example.shoppingappdemo.data.Shopper
import kotlinx.android.synthetic.main.fragment_list.*
import retrofit2.Call
import retrofit2.Response


class ListFragment : Fragment() {

    private lateinit var myShopperViewModel: ShopperViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Recycler View
        val shoppingAdapter = ShoppingListAdapter()
        recyclerview.adapter = shoppingAdapter
        recyclerview.layoutManager = LinearLayoutManager(requireContext())

        val shoppingService = (requireActivity() as MainActivity).shoppingService

        //Retrofit Call
        shoppingService.getAll().enqueue(object : retrofit2.Callback<List<Shopper>> {
            override fun onResponse(call: Call<List<Shopper>>, response: retrofit2.Response<List<Shopper>>) {
                Log.d("ListFragment", "Success in OnResponse")

                shoppingAdapter.setData(response.body()!!)
            }

            override fun onFailure(call: Call<List<Shopper>>, t: Throwable) {
                Log.d("ListFragment", "Success in OnFailure")
                Log.d("ListFragment", t.toString())
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.floatingActionButton2.setOnClickListener{
            findNavController().navigate((R.id.action_listFragment_to_addFragment))
        }
    }

}