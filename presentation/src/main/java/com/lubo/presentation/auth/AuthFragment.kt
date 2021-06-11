package com.lubo.presentation.auth

import android.os.Bundle
import androidx.core.view.marginBottom
import com.lubo.core.listener.KeyBoardState
import com.lubo.presentation.R
import com.lubo.presentation.base.BaseFragment
import com.lubo.presentation.databinding.AuthFragmentBinding
import com.lubo.presentation.extension.*

class AuthFragment : BaseFragment<AuthViewModel>() {

    override val viewBinding by provideViewBinding {
        AuthFragmentBinding.inflate(it)
    }

    override fun afterViewCreated(savedInstanceState: Bundle?) {

        viewBinding.apply {
            getToolbar()?.apply {
                setTitle(R.string.register)
            }

            btnContinue.isEnabled = false
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
            edTxtPhoneNumber.attachPhoneFormatter()
            edTxtPhoneNumber.attachPhoneValidator { isPhoneValid: Boolean ->
                btnContinue.isEnabled = isPhoneValid
            }

            btnContinue.setOnClickListener {
                viewModel.auth(edTxtPhoneNumber.getPhoneTextWithoutSpaces())
            }
        }
    }

}