package com.lubo.lubotestproject

import android.app.Application
import com.lubo.local.di.localModule
import com.lubo.presentation.di.presentationModule
import com.lubo.data.di.repositoryModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.singleton

class LuboApplication : Application(), DIAware {

    override val di = DI.lazy {
        bind() from singleton { this@LuboApplication }


        // modules
        import(localModule)
        import(repositoryModule)
        import(presentationModule)
    }
}