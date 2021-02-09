package com.lubo.presentation.di

import com.lubo.presentation.auth.AuthViewModel
import com.lubo.presentation.auth.AuthViewModelFactory
import com.lubo.presentation.onboarding.OnboardingViewModel
import com.lubo.presentation.onboarding.OnboardingViewModelFactory
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

val presentationModule = DI.Module("presentation") {
    bind() from provider { OnboardingViewModelFactory(instance()) }
    bind() from provider {
        AuthViewModelFactory(
            instance(),
            instance()
        )
    }
}