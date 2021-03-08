package com.example.beer.datasource.remote.models

import com.google.gson.annotations.SerializedName


data class HopsNetwork(

    @SerializedName("name") val name: String,
    @SerializedName("amount") val amountNetwork: VolumeNetwork,
    @SerializedName("add") val add: String,
    @SerializedName("attribute") val attribute: String
)