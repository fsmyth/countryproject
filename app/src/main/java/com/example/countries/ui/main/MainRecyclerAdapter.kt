package com.example.countries.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.countries.R
import com.example.countries.data.Country

class MainRecyclerAdapter(
    val context: Context,
    val countries: List<Country>,
    val itemListener: CountryItemListener
) :
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    override fun getItemCount() = countries.size

    //Inflate the individual country grid item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.country_grid_item, parent, false)
        return ViewHolder(view)
    }

    //Create an object for each item in the countries array
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        with(holder) {
            nameText?.let {
                it.text = country.name
                it.contentDescription = country.name
            }
            holder.itemView.setOnClickListener {
                itemListener.onCountryItemClick(country)
            }
        }
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
    }

    interface CountryItemListener {
        fun onCountryItemClick(country: Country)
    }
}