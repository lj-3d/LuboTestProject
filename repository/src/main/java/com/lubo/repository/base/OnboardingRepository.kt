package com.lubo.repository.base

import com.lubo.repository.model.OnboardingItem

interface OnboardingRepository {

    fun getOnboardingData(): MutableList<OnboardingItem>

    fun endOnboarding()

}