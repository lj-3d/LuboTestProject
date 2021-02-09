package com.lubo.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.lubo.presentation.extension.provideViewBinding
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI


abstract class BaseActivity<AndroidVModel : BaseViewModel> : AppCompatActivity(), DIAware {

    override val di by closestDI()

    protected abstract val viewBinding: ViewBinding?
    protected abstract val viewModel: AndroidVModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding?.root)
    }
}