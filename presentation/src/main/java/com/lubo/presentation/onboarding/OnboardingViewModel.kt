package com.lubo.presentation.onboarding

import android.app.Application
import com.lubo.presentation.R
import com.lubo.presentation.base.BaseViewModel
import com.lubo.repository.model.OnboardingItem

class OnboardingViewModel(application: Application) : BaseViewModel(application) {

    fun getOnboardingData(): MutableList<OnboardingItem> {
        return mutableListOf<OnboardingItem>().apply {
            add(
                OnboardingItem(
                    R.drawable.img_onboarding_1,
                    resources.getString(R.string.onboarding_message_1)
                )
            )
            add(
                OnboardingItem(
                    R.drawable.img_onboarding_2,
                    resources.getString(R.string.onboarding_message_2)
                )
            )
            add(
                OnboardingItem(
                    R.drawable.img_onboarding_3,
                    resources.getString(R.string.onboarding_message_3)
                )
            )
            add(
                OnboardingItem(
                    R.drawable.img_onboarding_4,
                    resources.getString(R.string.onboarding_message_4)
                )
            )
        }
    }

}