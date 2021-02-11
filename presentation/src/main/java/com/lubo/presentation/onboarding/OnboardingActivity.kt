package com.lubo.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.lubo.presentation.adapter.OnboardingAdapter
import com.lubo.presentation.auth.AuthActivity
import com.lubo.presentation.base.BaseActivity
import com.lubo.presentation.databinding.OnboardingActivityBinding
import com.lubo.presentation.extension.getSnapPosition
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
            btnContinue.isEnabled = true
            btnSkip.isEnabled = true

            var activeItem = 0

            rvOnboarding.apply {
                val layoutManager = LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL, false
                )
                setLayoutManager(layoutManager)
                adapter = OnboardingAdapter(viewModel.getOnboardingData())
                PagerSnapHelper().also {
                    it.attachToRecyclerView(this)
                    bubbleIndicator.attachRecyclerView(this@apply, it)
                    this@apply.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                            super.onScrolled(recyclerView, dx, dy)
                            activeItem = it.getSnapPosition(this@apply)
                        }
                    })
                }
                btnContinue.setOnClickListener {
                    if (activeItem == adapter?.itemCount?.minus(1)) {
                        finishOnboarding()
                    } else {
                        layoutManager
                            .scrollToPosition(activeItem + 1)
                    }
                }
            }

            btnSkip.setOnClickListener { finishOnboarding() }
        }
    }

    private fun finishOnboarding() {
        startActivity(Intent(this, AuthActivity::class.java))
        viewModel.finishOnboarding()
        finish()
    }


}