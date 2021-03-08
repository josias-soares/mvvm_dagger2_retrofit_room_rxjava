package com.example.beer.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun providesApplication(): Application = application

    @Provides
    @Singleton
    fun providesApplicationContext(): Context = application

//    viewModel { MainViewModel(androidApplication(), get()) }
//    viewModel { RegisterViewModel(androidApplication(), get(), get()) }
//    viewModel { TaskFormViewModel(androidApplication(), get(), get()) }
//    viewModel { AllTasksViewModel(androidApplication(), get()) }
//    viewModel { LoginViewModel(androidApplication(), get(), get(), get()) }
}