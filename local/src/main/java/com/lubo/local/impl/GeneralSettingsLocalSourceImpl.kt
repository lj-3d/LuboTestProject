package com.lubo.local.impl

import android.content.SharedPreferences
import androidx.core.content.edit
import com.lubo.local.base.Constants.SP_ONBOARDING_KEY
import com.lubo.local.base.GeneralSettingsLocalSource

internal class GeneralSettingsLocalSourceImpl(private val sharedPreferences: SharedPreferences) :
    GeneralSettingsLocalSource {

    override fun shouldShowOnboarding() = sharedPreferences.getBoolean(SP_ONBOARDING_KEY, false)

    override fun endOnboarding() = sharedPreferences.edit { putBoolean(SP_ONBOARDING_KEY, true) }

}