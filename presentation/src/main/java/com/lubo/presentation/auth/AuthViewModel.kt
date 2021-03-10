package com.lubo.presentation.auth

import android.app.Application
import androidx.lifecycle.viewModelScope
import com.lubo.presentation.base.BaseViewModel
import com.lubo.repository.base.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel(application: Application, private val authRepository: AuthRepository) :
    BaseViewModel(application) {

    fun auth(phoneNumber: String) {
        viewModelScope.launch {
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