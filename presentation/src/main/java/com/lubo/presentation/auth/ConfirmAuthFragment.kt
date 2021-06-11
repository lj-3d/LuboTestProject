package com.lubo.presentation.auth

import android.os.Bundle
import androidx.core.view.marginBottom
import com.lubo.core.listener.KeyBoardState
import com.lubo.presentation.R
import com.lubo.presentation.base.BaseFragment
import com.lubo.presentation.custom.SMSView
import com.lubo.presentation.databinding.ConfirmAuthFragmentBinding
import com.lubo.presentation.extension.*

class ConfirmAuthFragment : BaseFragment<AuthViewModel>() {

    override val viewBinding by provideViewBinding {
        ConfirmAuthFragmentBinding.inflate(it)
    }

    override fun afterViewCreated(savedInstanceState: Bundle?) {

        viewBinding.apply {
            getToolbar()?.apply {
                setTitle(R.string.register)
            }

            btnContinue.isEnabled = false
            btnContinue.setOnClickListener {
//                viewModel.auth(edTxtPhoneNumber.getPhoneTextWithoutSpaces())
            }
            smsView.onInputCodeListener = object : SMSView.OnInputCodeListener {
                override fun isCodeValid(valid: Boolean) {
                    btnContinue.isEnabled = valid
                }
            }
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