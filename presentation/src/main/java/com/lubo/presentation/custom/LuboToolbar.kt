package com.lubo.presentation.custom

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.lubo.presentation.R
import com.lubo.presentation.databinding.ToolbarBinding
import kotlin.math.roundToInt

class LuboToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val toolBar = ToolbarBinding.inflate(LayoutInflater.from(context))

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addView(toolBar.root)
    }

    fun onBack(onBack: () -> Unit) {
        toolBar.ivArrowBack.setOnClickListener {
            onBack()
        }
    }

    fun setTitle(titleStringId: Int) {
        setTitle(resources.getString(titleStringId))
    }

    fun setTitle(title: String) {
        toolBar.txtMainTitle.text = title
    }

}