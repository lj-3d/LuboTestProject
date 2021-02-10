package com.lubo.presentation.onboarding

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.adapter.OnboardingAdapter
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.custom.BubbleIndicator
import com.lubo.presentation.databinding.OnboardingActivityBinding
import com.lubo.presentation.extension.provideViewBinding
import com.lubo.presentation.extension.provideViewModel

class OnboardingActivity : BaseActivity<OnboardingViewModel>() {

    override val viewBinding by provideViewBinding {
        OnboardingActivityBinding.inflate(it)
    }
    override val viewModel: OnboardingViewModel by provideViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding.apply {
//            val tapeFace = ResourcesCompat.getFont(this@OnboardingActivity, R.font.montserrat_black)
//            tapeFace.apply {
//                btnContinue.typeface = this
//                btnSkip.typeface = this
//            }
            btnContinue.isEnabled = true
            btnSkip.isEnabled = true

            rvOnboarding.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                adapter = OnboardingAdapter(viewModel.getOnboardingData())
                PagerSnapHelper().also {
                    it.attachToRecyclerView(this)
                    bubbleIndicator.attachRecyclerView(this, it)
                }
            }
        }
    }


}