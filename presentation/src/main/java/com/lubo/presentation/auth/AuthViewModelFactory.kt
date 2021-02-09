package com.lubo.presentation.auth

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lubo.repository.base.AuthRepository

class AuthViewModelFactory(
    private val application: Application,
    private val authRepository: AuthRepository
) :
    ViewModelProvider.AndroidViewModelFactory(application) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(application, authRepository) as T
    }
}