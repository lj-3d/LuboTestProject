package com.lubo.repository.base

interface OnboardingRepository : BaseRepository {

    fun shouldShowOnboarding(): Boolean

    fun endOnboarding()

}