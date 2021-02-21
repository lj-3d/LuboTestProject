package com.lubo.presentation.auth

import android.os.Bundle
import androidx.core.view.marginBottom
import com.lubo.core.listener.KeyBoardState
import com.lubo.presentation.R
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.AuthActivityBinding
import com.lubo.presentation.extension.*

class AuthActivity : BaseActivity<AuthViewModel>() {

    override val viewBinding by provideViewBinding {
        AuthActivityBinding.inflate(it)
    }

    override val viewModel: AuthViewModel by provideViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding.apply {
            toolbar.onBack {
                popFragmentStackOrFinish()
            }
            addFragment(Pair(RegisterFragment(), null))
        }
    }
}