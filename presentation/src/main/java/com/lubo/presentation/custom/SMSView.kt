package com.lubo.presentation.custom

import android.content.Context
import android.graphics.Rect
import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.text.InputType
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.widget.addTextChangedListener
import com.lubo.presentation.R
import com.lubo.presentation.databinding.SmsCellBinding
import com.lubo.presentation.extension.showKeyboard
import kotlinx.android.synthetic.main.sms_cell.view.*


class SMSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val cellCount = 6

    private val cells = mutableListOf<TextView>()

    private val editText = EditText(context)

    var onInputCodeListener: OnInputCodeListener? = null

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        generateCell()
    }

    private fun generateCell() {
        orientation = HORIZONTAL
        cells.clear()
        for (index in 0 until cellCount) {
            val root = inflate(context, R.layout.sms_cell, null).apply {
                val txtDigitCell = findViewById<TextView>(R.id.txtDigitCell)
                cells.add(txtDigitCell)
                layoutParams = LayoutParams(0, LayoutParams.MATCH_PARENT, 1F)
            }
            addView(root)
        }

        editText.apply {
            layoutParams = LayoutParams(1, LayoutParams.MATCH_PARENT)
            filters = arrayOf<InputFilter>(LengthFilter(cellCount))
            inputType = InputType.TYPE_CLASS_NUMBER
            val array = arrayOfNulls<String>(cellCount)
            editText.addTextChangedListener {
                val digits = it?.toString()?.toCharArray()
//                Log.d("indexes size", "${digits?.size}")
                for (index in 0 until cellCount) {
                    if (index < digits?.size ?: 0) {
                        array[index] = digits?.get(index).toString()
                    } else {
                        array[index] = null
                    }
                }
                Log.d("indexes size", "${array?.size}")
                for (index in 0 until array.size) {
                    Log.d("indexes size", "${array[index]}")
                    val digit = array[index]
                    val cell = cells[index]
                    if (digit != cell.text) {
                        cell.text = digit.orEmpty()
                    }
                }
                onInputCodeListener?.isCodeValid(digits?.size == cellCount)
            }
            addView(this)
        }

        setOnClickListener {
            editText.showKeyboard()
        }
        postDelayed({
            editText.showKeyboard()
        }, 300)

    }

    interface OnInputCodeListener {
        fun isCodeValid(valid: Boolean)
    }


}