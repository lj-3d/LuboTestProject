package com.lubo.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.lubo.presentation.R
import kotlin.math.roundToInt

class LuboToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        orientation = VERTICAL
        setPadding(resources.getDimension(R.dimen.offset_16).roundToInt())
        gravity = Gravity.LEFT
        addView(AppCompatImageView(context).apply {
            this.setImageResource(R.drawable.ic_baseline_arrow_back_ios_24)
        })
    }

}