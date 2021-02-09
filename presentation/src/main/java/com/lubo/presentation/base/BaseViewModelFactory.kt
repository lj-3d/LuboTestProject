package com.lubo.presentation.base

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.DirectDI
import org.kodein.di.instanceOrNull

class BaseViewModelFactory(application: Application, private val diInjector: DirectDI) :
    AndroidViewModelFactory(application) {

    @Suppress("UNCHECKED_CAST")
    override fun <VM : ViewModel?> create(modelClass: Class<VM>): VM {
        return diInjector.instanceOrNull<ViewModel>(modelClass.simpleName) as VM
    }

}