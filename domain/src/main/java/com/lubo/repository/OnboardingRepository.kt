package com.lubo.repository

interface OnboardingRepository : BaseRepository {

    fun shouldShowOnboarding(): Boolean

    fun endOnboarding()

}