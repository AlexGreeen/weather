package com.example.weather.ui

import android.app.Application
import com.example.weather.ui.utils.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}