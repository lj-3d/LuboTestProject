package com.lubo.presentation.onboarding

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.adapter.OnboardingAdapter
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.OnboardingActivityBinding
import com.lubo.presentation.extension.provideViewBinding
import com.lubo.presentation.extension.provideViewModel

class OnboardingActivity : BaseActivity<OnboardingViewModel>() {

    override val viewBinding by provideViewBinding(OnboardingActivityBinding::inflate)
    override val viewModel: OnboardingViewModel by provideViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
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