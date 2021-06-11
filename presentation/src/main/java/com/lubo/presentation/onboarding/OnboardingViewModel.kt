package com.lubo.presentation.onboarding

import android.app.Application
import com.lubo.core.model.OnboardingModel
import com.lubo.presentation.R
import com.lubo.presentation.base.BaseViewModel
import com.lubo.repository.OnboardingRepository

class OnboardingViewModel(application: Application, private val repository: OnboardingRepository) :
    BaseViewModel(application) {

    fun getOnboardingData(): MutableList<OnboardingModel> {
        return mutableListOf<OnboardingModel>().apply {
            add(
                OnboardingModel(
                    R.drawable.img_onboarding_1,
                    resources.getString(R.string.onboarding_message_1)
                )
            )
            add(
                OnboardingModel(
                    R.drawable.img_onboarding_2,
                    resources.getString(R.string.onboarding_message_2)
                )
            )
            add(
                OnboardingModel(
                    R.drawable.img_onboarding_3,
                    resources.getString(R.string.onboarding_message_3)
                )
            )
            add(
                OnboardingModel(
                    R.drawable.img_onboarding_4,
                    resources.getString(R.string.onboarding_message_4)
                )
            )
        }
    }

    fun finishOnboarding() {
        repository.endOnboarding()
    }


}