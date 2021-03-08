package com.example.beer.datasource.remote.models

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class BeersRequest(
    @SerializedName("beer_name") val beerName: String,
    @SerializedName("ids") val ids: String,
    @SerializedName("page") val page: Int,
    @SerializedName("per_page") val perPage: Int,
){
    companion object{
        fun objectToQueryParams(aRequest: Any?): Map<String, String> {
            val lJson = Gson().toJson(aRequest)
            val lType = object : TypeToken<Map<String, String>>() {}.type
            return Gson().fromJson(lJson, lType)
        }
    }
}