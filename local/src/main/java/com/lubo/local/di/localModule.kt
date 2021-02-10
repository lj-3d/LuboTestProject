package com.lubo.local.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.lubo.local.base.Constants
import com.lubo.local.base.UserProfileLocalSource
import com.lubo.local.impl.UserProfileLocalSourceImpl
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val localModule = DI.Module("localModule") {
    bind() from singleton { provideSharedPreferences(instance()) }

    bind<UserProfileLocalSource>() with singleton { UserProfileLocalSourceImpl(instance()) }
}


private fun provideSharedPreferences(application: Application): SharedPreferences {
    return application.applicationContext.getSharedPreferences(
        Constants.SHARED_PREFERENCE_NAME,
        Context.MODE_PRIVATE
    )
}