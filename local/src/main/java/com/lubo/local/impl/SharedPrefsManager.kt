package com.lubo.local.impl

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.lubo.local.base.Constants

object SharedPrefsManager {

    var sharedPrefs: SharedPreferences? = null

    fun init(application: Application) {
        sharedPrefs = application.applicationContext.getSharedPreferences(
            Constants.SHARED_PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

}