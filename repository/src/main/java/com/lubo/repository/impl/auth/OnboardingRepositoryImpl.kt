package com.lubo.repository.impl.auth

import com.lubo.repository.base.OnboardingRepository
import com.lubo.repository.model.OnboardingItem

internal class OnboardingRepositoryImpl() : OnboardingRepository {

    override fun getOnboardingData(): MutableList<OnboardingItem> {
        return mutableListOf()
    }

    override fun endOnboarding() {

    }

}