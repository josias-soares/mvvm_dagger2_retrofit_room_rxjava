package com.example.beer.shared.listener

import com.example.beer.domain.models.BeerRecipe

interface BeerListener {
    fun onDetails(id: Int?)
    fun onFavorite(beerRecipe: BeerRecipe?)
    fun onDeleteFavorite(id: Int?)
}