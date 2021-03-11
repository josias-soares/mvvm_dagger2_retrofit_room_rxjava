package com.example.beer.di.module

import android.content.Context
import com.example.beer.datasource.BeerRepository
import com.example.beer.datasource.BeerRepositoryImpl
import com.example.beer.datasource.local.BeerDAO
import com.example.beer.datasource.local.mappers.BeerEntityMapper
import com.example.beer.datasource.remote.mappers.BeerNetworkMapper
import com.example.beer.datasource.remote.services.BeerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providerBeerRepository(
        @ApplicationContext context: Context,
        service: BeerService,
        beerDAO: BeerDAO,
        beerNetworkMapper: BeerNetworkMapper,
        beerEntityMapper: BeerEntityMapper
    ): BeerRepository {
        return BeerRepositoryImpl(context, service, beerDAO, beerNetworkMapper, beerEntityMapper)
    }
}