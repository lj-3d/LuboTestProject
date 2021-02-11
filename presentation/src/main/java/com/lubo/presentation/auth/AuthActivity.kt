package com.lubo.presentation.auth

import android.os.Bundle
import android.util.Log
import androidx.core.view.marginBottom
import com.lubo.core.listener.KeyBoardState
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
        viewModel.auth("278732783782378")

        viewBinding.apply {

            llPhoneNumber.setOnClickListener { edTxtPhoneNumber.showKeyboard() }
            val lastBottomMargin = btnContinue.marginBottom
            setOnKeyboardChangeListener { state, keyboardHeight ->
                when (state) {
                    KeyBoardState.OPENED -> {
                        btnContinue.setBottomMargin(keyboardHeight)
                    }
                    KeyBoardState.CLOSED -> {
                        btnContinue.setBottomMargin(lastBottomMargin)
                    }
                }
            }
        }


    }

}