package com.example.beer.domain.models
import java.io.Serializable

data class BeerRecipe(
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String,
    val abv: Int?,
    val ibu: Int?,
    val ebc: Int?,
    val volume: Volume?,
    val boilVolume: Volume?,
    val ingredients: Ingredients?,
    val contributedBy: String?,
    val favorite: Boolean?
) : Serializable