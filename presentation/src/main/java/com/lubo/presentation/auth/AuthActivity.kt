package com.lubo.presentation.auth

import android.os.Bundle
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.R

class AuthActivity : BaseActivity<AuthViewModel>() {

    override var layoutId = R.layout.auth_activity

    override var viewModelClass: Class<AuthViewModel> = AuthViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.auth("+380974213434")
    }
}