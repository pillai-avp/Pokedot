package com.ahponicloqui.pokedot

import android.app.Application
import android.util.Log
import com.ahponicloqui.pokedot.common.commonModule
import com.ahponicloqui.pokedot.ui.screens.home.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class PokedotApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedotApplication)
            modules(listOf(commonModule, homeModule))
        }

        initLogging()
    }

    private fun initLogging() {
        Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}