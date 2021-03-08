package com.example.beer.datasource.remote.models

import com.google.gson.annotations.SerializedName

data class BeerRecipeNetwork(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("tagline") val tagline: String,
    @SerializedName("first_brewed") val firstBrewed: String,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("abv") val abv: Int,
    @SerializedName("ibu") val ibu: Int,
    @SerializedName("ebc") val ebc: Int,
    @SerializedName("volume") val volume: VolumeNetwork,
    @SerializedName("boil_volume") val boilVolume: VolumeNetwork,
    @SerializedName("ingredients") val ingredients: IngredientsNetwork,
    @SerializedName("contributed_by") val contributedBy: String
)