package com.lubo.presentation.onboarding

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.adapter.OnboardingAdapter
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.OnboardingActivityBinding

class OnboardingActivity : BaseActivity<OnboardingViewModel, OnboardingActivityBinding>() {

    override var viewModelClass: Class<OnboardingViewModel> = OnboardingViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = OnboardingActivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        viewBinding.apply {
            btnContinue.isEnabled = true
            btnSkip.isEnabled = false

            rvOnboarding.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = OnboardingAdapter(viewModel.getOnboardingData())
                PagerSnapHelper().attachToRecyclerView(this)
            }
        }
    }


}