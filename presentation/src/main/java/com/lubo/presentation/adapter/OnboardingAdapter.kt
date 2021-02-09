package com.lubo.presentation.adapter

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lubo.presentation.R
import com.lubo.repository.model.OnboardingItem
import org.w3c.dom.Text

class OnboardingAdapter(val onboardingItems: MutableList<OnboardingItem>) :
    BaseQuickAdapter<OnboardingItem, BaseViewHolder>(R.layout.item_onboarding, onboardingItems) {

    override fun convert(holder: BaseViewHolder, item: OnboardingItem) {
        with(holder) {
            getView<AppCompatImageView>(R.id.imgOnboarding).setImageResource(item.imgResource)
            getView<TextView>(R.id.txtOnboarding).text = item.description
        }
    }

}