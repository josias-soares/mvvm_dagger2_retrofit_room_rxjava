package com.example.beer.datasource.remote.mappers

import com.example.beer.datasource.remote.models.VolumeNetwork
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.Volume
import javax.inject.Inject

class VolumeNetworkMapper
@Inject
constructor() :
    EntityMapper<VolumeNetwork, Volume> {

    override fun mapFromEntity(dataSourceModel: VolumeNetwork): Volume {
        return Volume(
            value = dataSourceModel.value,
            unit = dataSourceModel.unit
        )
    }

    override fun mapToEntity(domainModel: Volume): VolumeNetwork {

        return VolumeNetwork(
            value = domainModel.value,
            unit = domainModel.unit
        )
    }

    fun mapFromEntityList(entities: List<VolumeNetwork>): List<Volume> {
        return entities.map { mapFromEntity(it) }
    }
}











