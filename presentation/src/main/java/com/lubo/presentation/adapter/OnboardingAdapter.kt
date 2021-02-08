package com.lubo.presentation.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lubo.presentation.R
import com.lubo.repository.model.OnboardingItem

class OnboardingAdapter(val onboardingItems: MutableList<OnboardingItem>) :
    BaseQuickAdapter<OnboardingItem, BaseViewHolder>(R.layout.item_onboarding, onboardingItems) {

    override fun convert(holder: BaseViewHolder, item: OnboardingItem) {
        with(holder) {
            (getView(R.id.imgOnboarding) as AppCompatImageView).setImageResource(item.imgResource)
            (getView(R.id.txtOnboarding) as AppCompatTextView).text = item.description
        }
    }

}