package com.lubo.presentation.auth

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.lubo.presentation.base.BaseViewModel
import com.lubo.repository.impl.auth.AuthRepositoryImpl
import com.lubo.impl.network.auth.AuthMapper
import com.lubo.impl.network.auth.AuthNetSourceImpl
import com.lubo.impl.network.auth.TokenMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : BaseViewModel(application) {

    private val authRepository: AuthRepositoryImpl by lazy {
        AuthRepositoryImpl(
            AuthNetSourceImpl(),
            AuthMapper(),
            TokenMapper()
        )
    }

    fun auth(phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            authRepository.auth(phoneNumber)
        }
    }

    fun resendCodeAsync(phoneNumber: String) {
        viewModelScope.launch {
            authRepository.resendCodeAsync(phoneNumber)
        }
    }

    fun refreshAsync(refreshToken: String) {
        viewModelScope.launch {
            authRepository.refreshAsync(refreshToken)
        }
    }

    fun auth(phoneNumber: String, code: Int) {
        viewModelScope.launch {
            authRepository.verifyCodeAsync(phoneNumber, code)
        }
    }

}