package com.example.beer.di

import android.app.Application
import androidx.room.Room
import com.example.beer.datasource.local.BeerDAO
import com.example.beer.datasource.local.BeerDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule(private val application: Application) {
    @Singleton
    @Provides
    fun provideDb(): BeerDatabase {
        return Room.databaseBuilder(
            application.applicationContext,
            BeerDatabase::class.java,
            BeerDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBeerDAO(beerDatabase: BeerDatabase): BeerDAO {
        return beerDatabase.beerDAO()
    }
}