package com.example.beer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beer.R
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.BeerListener
import com.example.beer.view.viewholder.BeerViewHolder

class BeerAdapter(private val beersRemote : List<BeerRecipe>, private val beersFavorite : List<BeerRecipe>, private val listener: BeerListener) : RecyclerView.Adapter<BeerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.row_beer_list, parent, false)

        return BeerViewHolder(item, listener)
    }

    override fun getItemCount(): Int {
        return beersRemote.count()
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        holder.bindData(beersRemote[position])
    }
}