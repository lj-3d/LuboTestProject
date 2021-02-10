package com.lubo.repository.impl

import com.lubo.local.base.UserProfileLocalSource
import com.lubo.repository.base.OnboardingRepository
import com.lubo.repository.model.OnboardingItem

internal class OnboardingRepositoryImpl(private val userProfileLocalSource: UserProfileLocalSource) :
    OnboardingRepository {

    override fun getOnboardingData(): MutableList<OnboardingItem> {
        return mutableListOf()
    }

    override fun endOnboarding() {
        userProfileLocalSource.getToken()
    }

}