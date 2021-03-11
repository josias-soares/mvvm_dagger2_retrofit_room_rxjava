package com.example.beer.di.module

import android.content.Context
import androidx.room.Room
import com.example.beer.datasource.local.BeerDAO
import com.example.beer.datasource.local.BeerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
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