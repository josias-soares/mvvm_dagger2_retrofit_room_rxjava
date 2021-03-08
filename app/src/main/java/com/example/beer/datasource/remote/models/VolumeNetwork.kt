package com.example.beer.datasource.remote.models

import com.google.gson.annotations.SerializedName


data class VolumeNetwork (

	@SerializedName("value") val value : Int,
	@SerializedName("unit") val unit : String
)