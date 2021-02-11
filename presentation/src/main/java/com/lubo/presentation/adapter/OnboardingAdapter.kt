package com.lubo.presentation.adapter

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lubo.presentation.R
import com.lubo.core.model.OnboardingModel

class OnboardingAdapter(val onboardingModels: MutableList<OnboardingModel>) :
    BaseQuickAdapter<OnboardingModel, BaseViewHolder>(R.layout.item_onboarding, onboardingModels) {

    override fun convert(holder: BaseViewHolder, model: OnboardingModel) {
        with(holder) {
            getView<AppCompatImageView>(R.id.imgOnboarding).setImageResource(model.imgResource)
            getView<TextView>(R.id.txtOnboarding).text = model.description
        }
    }

}