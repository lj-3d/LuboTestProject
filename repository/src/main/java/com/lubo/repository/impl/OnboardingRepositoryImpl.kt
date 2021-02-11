package com.lubo.repository.impl

import com.lubo.local.base.GeneralSettingsLocalSource
import com.lubo.repository.base.OnboardingRepository

internal class OnboardingRepositoryImpl(
    private val generalSettingsLocalSource: GeneralSettingsLocalSource
) : OnboardingRepository {

    override fun shouldShowOnboarding() = generalSettingsLocalSource.shouldShowOnboarding()

    override fun endOnboarding() = generalSettingsLocalSource.endOnboarding()

}