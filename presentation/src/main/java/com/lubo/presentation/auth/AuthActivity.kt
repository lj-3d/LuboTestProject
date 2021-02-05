package com.lubo.presentation.auth

import android.os.Bundle
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.AuthActivityBinding

class AuthActivity : BaseActivity<AuthViewModel, AuthActivityBinding>() {

    override var viewModelClass: Class<AuthViewModel> = AuthViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = AuthActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        viewModel.auth("+380974213434")
    }


}