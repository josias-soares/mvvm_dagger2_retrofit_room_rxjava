package com.example.beer.di.module

import com.example.beer.datasource.remote.services.BeerService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkApiModule {

    @Singleton
    @Provides
    fun provideBeerService(
        retrofit: Retrofit.Builder
    ): BeerService {
        return retrofit
            .build()
            .create(BeerService::class.java)
    }
}