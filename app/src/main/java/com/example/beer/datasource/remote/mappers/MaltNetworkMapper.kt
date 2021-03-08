package com.example.beer.datasource.remote.mappers

import com.example.beer.datasource.remote.models.MaltNetwork
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.Malt
import javax.inject.Inject

class MaltNetworkMapper
@Inject
constructor(
    private val volumeNetworkMapper: VolumeNetworkMapper,
) :
    EntityMapper<MaltNetwork, Malt> {

    override fun mapFromEntity(dataSourceModel: MaltNetwork): Malt {
        return Malt(
            name = dataSourceModel.name,
            amount = volumeNetworkMapper.mapFromEntity(dataSourceModel.amountNetwork)
        )
    }

    override fun mapToEntity(domainModel: Malt): MaltNetwork {

        return MaltNetwork(
            name = domainModel.name,
            amountNetwork = volumeNetworkMapper.mapToEntity(domainModel.amount)
        )
    }

    fun mapFromEntityList(entities: List<MaltNetwork>): List<Malt> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<Malt>): List<MaltNetwork> {
        return entities.map { mapToEntity(it) }
    }
}











