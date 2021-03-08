package com.example.beer.di

import com.example.beer.datasource.remote.services.BeerService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkApiModule {

    @Singleton
    @Provides
    fun provideBeerService(retrofit: Retrofit.Builder): BeerService {
        return retrofit
            .build()
            .create(BeerService::class.java)
    }

}