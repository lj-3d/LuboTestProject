package com.lubo.presentation.auth

import android.os.Bundle
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.AuthActivityBinding
import com.lubo.presentation.extension.provideViewModel

class AuthActivity : BaseActivity<AuthViewModel, AuthViewModelFactory, AuthActivityBinding>() {

    override val viewModel: AuthViewModel by provideViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = AuthActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        viewModel.auth("278732783782378")
    }

}