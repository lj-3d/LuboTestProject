package com.lubo.repository.base

interface OnboardingRepository {

    fun shouldShowOnboarding(): Boolean

    fun endOnboarding()

}