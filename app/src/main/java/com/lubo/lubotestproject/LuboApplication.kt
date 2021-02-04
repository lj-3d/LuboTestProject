package com.lubo.lubotestproject

import android.app.Application
import com.lubo.local.impl.SharedPrefsManager

class LuboApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.init(this)
    }
}