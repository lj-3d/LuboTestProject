package com.lubo.lubotestproject

import android.app.Application
import com.lubo.local.impl.SharedPrefsManager
import com.lubo.presentation.di.presentationModule
import com.lubo.repository.di.repositoryModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.singleton

class LuboApplication : Application(), DIAware {

    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.init(this)
    }

    override val di = DI.lazy {
        bind() from singleton { this@LuboApplication }

        // modules
        import(repositoryModule)
        import(presentationModule)

    }
}