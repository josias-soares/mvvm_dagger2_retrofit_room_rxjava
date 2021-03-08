package com.example.beer.datasource.remote.mappers

import com.example.beer.datasource.remote.models.BeerRecipeNetwork
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.BeerRecipe
import javax.inject.Inject

class BeerNetworkMapper
@Inject
constructor(
    private val volumeNetworkMapper: VolumeNetworkMapper,
    private val ingredientsNetworkMapper: IngredientsNetworkMapper,
) :
    EntityMapper<BeerRecipeNetwork, BeerRecipe> {

    override fun mapFromEntity(dataSourceModel: BeerRecipeNetwork): BeerRecipe {
        return BeerRecipe(
            id = dataSourceModel.id,
            name = dataSourceModel.name,
            tagline = dataSourceModel.tagline,
            firstBrewed = dataSourceModel.firstBrewed,
            description = dataSourceModel.description,
            imageUrl = dataSourceModel.imageUrl,
            abv = dataSourceModel.abv,
            ibu = dataSourceModel.ibu,
            ebc = dataSourceModel.ebc,
            volume = volumeNetworkMapper.mapFromEntity(dataSourceModel.volume),
            boilVolume = volumeNetworkMapper.mapFromEntity(dataSourceModel.boilVolume),
            ingredients = ingredientsNetworkMapper.mapFromEntity(dataSourceModel.ingredients),
            contributedBy = dataSourceModel.contributedBy,
        )
    }

    override fun mapToEntity(domainModel: BeerRecipe): BeerRecipeNetwork {

        return BeerRecipeNetwork(
            id = domainModel.id,
            name = domainModel.name,
            tagline = domainModel.tagline,
            firstBrewed = domainModel.firstBrewed,
            description = domainModel.description,
            imageUrl = domainModel.imageUrl,
            abv = domainModel.abv!!,
            ibu = domainModel.ibu!!,
            ebc = domainModel.ebc!!,
            volume = volumeNetworkMapper.mapToEntity(domainModel.volume!!),
            boilVolume = volumeNetworkMapper.mapToEntity(domainModel.boilVolume!!),
            ingredients = ingredientsNetworkMapper.mapToEntity(domainModel.ingredients!!),
            contributedBy = domainModel.contributedBy!!,
        )
    }

    fun mapFromEntityList(entities: List<BeerRecipeNetwork>): List<BeerRecipe> {
        return entities.map { mapFromEntity(it) }
    }
}











