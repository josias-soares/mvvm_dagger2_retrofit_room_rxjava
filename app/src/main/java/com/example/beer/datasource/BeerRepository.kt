package com.example.beer.datasource

import com.example.beer.datasource.remote.models.BeersRequest
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.APIListener

interface BeerRepository {
    fun favorites(listener: APIListener<List<BeerRecipe>>)

    fun listRemote(listener: APIListener<List<BeerRecipe>>)

    fun save(beerRecipe: BeerRecipe, listener: APIListener<Boolean>)

    fun getBeers(request: BeersRequest, listener: APIListener<List<BeerRecipe>>)

    fun delete(id: Int, listener: APIListener<Boolean>)
}