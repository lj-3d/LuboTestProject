package com.lubo.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.AuthActivityBinding
import com.lubo.presentation.extension.provideViewBinding
import com.lubo.presentation.extension.provideViewModel

class AuthActivity : BaseActivity<AuthViewModel>() {

    override val viewBinding by provideViewBinding(AuthActivityBinding::inflate)

    override val viewModel: AuthViewModel by provideViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.auth("278732783782378")
    }

}