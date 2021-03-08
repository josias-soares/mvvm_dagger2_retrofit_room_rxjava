package com.example.beer.datasource.remote.services

import com.example.beer.datasource.remote.models.BeerRecipeNetwork
import retrofit2.Call
import retrofit2.http.*

interface BeerService {
    @GET("beers")
    fun all(): Call<List<BeerRecipeNetwork>>

    @GET("beers")
    fun getBeers(@QueryMap aParams: Map<String, String>) : Call<List<BeerRecipeNetwork>>
}