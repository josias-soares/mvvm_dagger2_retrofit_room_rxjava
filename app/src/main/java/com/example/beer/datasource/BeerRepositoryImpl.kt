package com.example.beer.datasource

import android.content.Context
import com.example.beer.R
import com.example.beer.datasource.local.BeerDAO
import com.example.beer.datasource.local.mappers.BeerEntityMapper
import com.example.beer.datasource.remote.mappers.BeerNetworkMapper
import com.example.beer.datasource.remote.models.BeerRecipeNetwork
import com.example.beer.datasource.remote.models.BeersRequest
import com.example.beer.datasource.remote.models.BeersRequest.Companion.objectToQueryParams
import com.example.beer.datasource.remote.services.BeerService
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.Constants
import com.example.beer.shared.helper.ConnectionHelper.Companion.isConnectionAvailable
import com.example.beer.shared.listener.APIListener
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


class BeerRepositoryImpl @Inject constructor(
    private val context: Context,
    private val service: BeerService,
    private val beerDAO: BeerDAO,
    private val beerNetworkMapper: BeerNetworkMapper,
    private val beerEntityMapper: BeerEntityMapper
) : BeerRepository {
    override fun favorites(listener: APIListener<List<BeerRecipe>>) {
        var list = beerDAO.getAll()

        if (list.isNullOrEmpty()) {
            list = listOf()
        }

        listener.onSuccess(beerEntityMapper.mapFromEntityList(list))

    }

    override fun listRemote(listener: APIListener<List<BeerRecipe>>) {
        if (!isConnectionAvailable(context)) {
            listener.onFailure(context.getString(R.string.error_internet_connection))
            return
        }

        val call: Call<List<BeerRecipeNetwork>> = service.all()

        call.enqueue(object : Callback<List<BeerRecipeNetwork>> {
            override fun onResponse(
                call: Call<List<BeerRecipeNetwork>>,
                response: Response<List<BeerRecipeNetwork>>
            ) {
                if (response.code() != Constants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()
                        ?.let { listener.onSuccess(beerNetworkMapper.mapFromEntityList(it)) }
                }
            }

            override fun onFailure(call: Call<List<BeerRecipeNetwork>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.error_unexpected))
            }

        })
    }

    override fun save(beerRecipe: BeerRecipe, listener: APIListener<Boolean>) {
        try {
            val beerEntity = beerEntityMapper.mapToEntity(beerRecipe)
            beerDAO.save(beerEntity)

            listener.onSuccess(true)
        } catch (e: Exception) {
            listener.onFailure(context.getString(R.string.error_unexpected))
        }
    }

    override fun getBeers(request: BeersRequest, listener: APIListener<List<BeerRecipe>>) {
        if (!isConnectionAvailable(context)) {
            listener.onFailure(context.getString(R.string.error_internet_connection))
            return
        }

        val call: Call<List<BeerRecipeNetwork>> = service.getBeers(objectToQueryParams(request))

        call.enqueue(object : Callback<List<BeerRecipeNetwork>> {
            override fun onResponse(
                call: Call<List<BeerRecipeNetwork>>,
                response: Response<List<BeerRecipeNetwork>>
            ) {
                if (response.code() != Constants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFailure(validation)
                } else {
                    response.body()
                        ?.let { listener.onSuccess(beerNetworkMapper.mapFromEntityList(it)) }
                }
            }

            override fun onFailure(call: Call<List<BeerRecipeNetwork>>, t: Throwable) {
                listener.onFailure(context.getString(R.string.error_unexpected))
            }

        })
    }

    override fun delete(id: Int, listener: APIListener<Boolean>) {
        try {
            beerDAO.deleteById(id)

            listener.onSuccess(true)
        } catch (e: Exception) {
            listener.onFailure(context.getString(R.string.error_unexpected))
        }
    }
}