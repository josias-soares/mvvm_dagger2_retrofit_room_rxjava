package com.example.beer

import android.app.Application
import com.example.beer.di.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    DataModule::class,
    NetworkModule::class,
    NetworkApiModule::class,
])
interface ApplicationComponent {

}

open class BaseApplication : Application() {
//    protected fun applicationInjector(): AndroidInjector<out DaggerApplication?>? {
//        val component: ApplicationComponent =
//            DaggerApplicationComponent.builder().application(this).build()
//        component.inject(this)
//        return component
//    }
}