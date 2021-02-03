package com.lubo.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


abstract class BaseActivity<AndroidViewModel : BaseViewModel> : AppCompatActivity() {

    protected abstract var layoutId: Int
    protected abstract var viewModelClass: Class<AndroidViewModel>

    protected val viewModel: AndroidViewModel by lazy {
        ViewModelProvider.AndroidViewModelFactory.getInstance(
            application
        ).create(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
    }

}