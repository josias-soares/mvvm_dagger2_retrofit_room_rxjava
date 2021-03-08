package com.example.beer.domain.models


data class Ingredients(
    val malt: List<Malt>,
    val hops: List<Hops>,
    val yeast: String
)