package com.fakeshop.android

import android.app.Application
import timber.log.Timber

class FakeShopApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // enable Timber in debug mode
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }
}