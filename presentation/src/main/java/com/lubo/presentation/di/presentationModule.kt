package com.lubo.presentation.di

import androidx.lifecycle.ViewModelProvider
import com.lubo.presentation.auth.AuthViewModel
import com.lubo.presentation.base.BaseViewModelFactory
import com.lubo.presentation.extension.bindViewModel
import com.lubo.presentation.onboarding.OnboardingViewModel
import org.kodein.di.*

val presentationModule = DI.Module("presentation") {
    bindViewModel<OnboardingViewModel>() with provider { OnboardingViewModel(instance()) }
    bindViewModel<AuthViewModel>() with provider { AuthViewModel(instance(), instance()) }

    bind<ViewModelProvider.AndroidViewModelFactory>() with singleton {
        BaseViewModelFactory(
            instance(),
            di.direct
        )
    }
}