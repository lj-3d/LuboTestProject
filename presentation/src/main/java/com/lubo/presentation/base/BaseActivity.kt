package com.lubo.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI


abstract class BaseActivity<AndroidVModel : BaseViewModel
        , VModelFactory : ViewModelProvider.AndroidViewModelFactory
        , BindingView : androidx.viewbinding.ViewBinding> : AppCompatActivity(), DIAware {

    override val di by closestDI()

    protected lateinit var viewBinding: BindingView
    protected abstract val viewModel: AndroidVModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

    }
}