package com.lubo.presentation.custom

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.lubo.presentation.R

class LuboButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        refreshDrawableState()
        jumpDrawablesToCurrentState()
    }

    var customTintBackground: Int = backgroundTintList?.defaultColor ?: R.color.btn_primary_color
        set(value) {
            backgroundTintList = ColorStateList.valueOf(value)
            field = value
        }

    var customTextColor: Int = textColors?.defaultColor ?: R.color.white_40
        set(value) {
            setTextColor(value)
            field = value
        }
}