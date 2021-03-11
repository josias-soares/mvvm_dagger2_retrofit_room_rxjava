package com.example.beer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class BaseApplication : Application() {
    //val appComponent = DaggerApplicationComponent.create()
}