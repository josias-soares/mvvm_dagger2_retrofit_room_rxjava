package com.example.beer.datasource.remote.mappers

import com.example.beer.datasource.remote.models.IngredientsNetwork
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.Ingredients
import javax.inject.Inject

class IngredientsNetworkMapper
@Inject
constructor(
    private val hopsNetworkMapper: HopsNetworkMapper,
    private val maltNetworkMapper: MaltNetworkMapper,
) :
    EntityMapper<IngredientsNetwork, Ingredients> {

    override fun mapFromEntity(dataSourceModel: IngredientsNetwork): Ingredients {
        return Ingredients(
            malt = maltNetworkMapper.mapFromEntityList(dataSourceModel.maltNetwork),
            hops = hopsNetworkMapper.mapFromEntityList(dataSourceModel.hops),
            yeast = dataSourceModel.yeast,
        )
    }

    override fun mapToEntity(domainModel: Ingredients): IngredientsNetwork {

        return IngredientsNetwork(
            maltNetwork = maltNetworkMapper.mapToEntityList(domainModel.malt),
            hops = hopsNetworkMapper.mapToEntityList(domainModel.hops),
            yeast = domainModel.yeast,
        )
    }

    fun mapFromEntityList(entities: List<IngredientsNetwork>): List<Ingredients> {
        return entities.map { mapFromEntity(it) }
    }
}











