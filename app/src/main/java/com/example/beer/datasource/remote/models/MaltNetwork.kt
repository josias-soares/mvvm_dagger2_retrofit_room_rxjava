package com.example.beer.datasource.remote.models

import com.google.gson.annotations.SerializedName


data class MaltNetwork(
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amountNetwork: VolumeNetwork
)