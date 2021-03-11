package com.example.beer.di.module

import com.example.beer.datasource.local.mappers.BeerEntityMapper
import com.example.beer.datasource.local.models.BeerEntity
import com.example.beer.datasource.remote.mappers.*
import com.example.beer.datasource.remote.models.*
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    @Singleton
    fun providerBeerNetworkMapper(
        volumeNetworkMapper: VolumeNetworkMapper,
        ingredientsNetworkMapper: IngredientsNetworkMapper,
    ): EntityMapper<BeerRecipeNetwork, BeerRecipe> {
        return BeerNetworkMapper(volumeNetworkMapper, ingredientsNetworkMapper)
    }

    @Provides
    @Singleton
    fun providerBeerEntityMapper(): EntityMapper<BeerEntity, BeerRecipe> {
        return BeerEntityMapper()
    }

    @Provides
    @Singleton
    fun providerVolumeNetworkMapper(): EntityMapper<VolumeNetwork, Volume> {
        return VolumeNetworkMapper()
    }

    @Provides
    @Singleton
    fun providerIngredientsNetworkMapper(
        hopsNetworkMapper: HopsNetworkMapper,
        maltNetworkMapper: MaltNetworkMapper,
    ): EntityMapper<IngredientsNetwork, Ingredients> {
        return IngredientsNetworkMapper(hopsNetworkMapper, maltNetworkMapper)
    }

    @Provides
    @Singleton
    fun providerHopsNetworkMapper(
        volumeNetworkMapper: VolumeNetworkMapper,
    ): EntityMapper<HopsNetwork, Hops> {
        return HopsNetworkMapper(volumeNetworkMapper)
    }

    @Provides
    @Singleton
    fun providerMaltNetworkMapper(
        volumeNetworkMapper: VolumeNetworkMapper,
    ): EntityMapper<MaltNetwork, Malt> {
        return MaltNetworkMapper(volumeNetworkMapper)
    }
}