package com.example.beer.datasource.remote.models

import com.google.gson.annotations.SerializedName


data class IngredientsNetwork (

    @SerializedName("malt") val maltNetwork : List<MaltNetwork>,
    @SerializedName("hops") val hops : List<HopsNetwork>,
    @SerializedName("yeast") val yeast : String
)