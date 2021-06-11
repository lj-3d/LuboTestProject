package com.lubo.presentation.auth

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.lubo.entity.AuthEntity
import com.lubo.presentation.base.BaseViewModel
import com.lubo.presentation.extension.launch
import com.lubo.repository.AuthRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class AuthViewModel(application: Application, private val authRepository: AuthRepository) :
    BaseViewModel(application) {

    fun auth(phoneNumber: String) {
        launch({
            authRepository.auth(phoneNumber)
        }, {
            errorListener?.showError(Exception(it.message))
        }, {
            Log.d("Exception ->", it.message.toString())
        })
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