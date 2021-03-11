package com.example.beer.di.module

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    @Singleton
//    fun providesApplication(application: Application): Application {
//        return application
//    }
//
//    @Provides
//    @Singleton
//    fun providesApplicationContext(application: Application): Context {
//        return application.applicationContext
//    }
}