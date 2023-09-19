package com.funandearn.admin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//Step 1 for Hilt..
@HiltAndroidApp
class MyApplication : Application()  {
    override fun onCreate() {
        super.onCreate()
    }
}