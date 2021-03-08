package com.example.beer.datasource.remote.mappers

import com.example.beer.datasource.remote.models.HopsNetwork
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.Hops
import javax.inject.Inject

class HopsNetworkMapper
@Inject
constructor(
    private val volumeNetworkMapper: VolumeNetworkMapper,
) :
    EntityMapper<HopsNetwork, Hops> {

    override fun mapFromEntity(dataSourceModel: HopsNetwork): Hops {
        return Hops(
            name = dataSourceModel.name,
            amount = volumeNetworkMapper.mapFromEntity(dataSourceModel.amountNetwork),
            add = dataSourceModel.add,
            attribute = dataSourceModel.attribute,
        )
    }

    override fun mapToEntity(domainModel: Hops): HopsNetwork {

        return HopsNetwork(
            name = domainModel.name,
            amountNetwork = volumeNetworkMapper.mapToEntity(domainModel.amount),
            add = domainModel.add,
            attribute = domainModel.attribute,
        )
    }

    fun mapFromEntityList(entities: List<HopsNetwork>): List<Hops> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(entities: List<Hops>): List<HopsNetwork> {
        return entities.map { mapToEntity(it) }
    }
}











