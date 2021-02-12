package com.lubo.presentation.extension

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import androidx.viewbinding.ViewBinding
import com.lubo.presentation.R
import org.kodein.di.DI.Builder
import org.kodein.di.DI.Builder.TypeBinder
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.direct
import org.kodein.di.instance


inline fun <reified VM : AndroidViewModel> Builder.bindViewModel(override: Boolean = false): TypeBinder<VM> {
    return bind<VM>(VM::class.java.simpleName, override)
}

inline fun <reified VM : AndroidViewModel, T> T.provideViewModel(): Lazy<VM>
        where T : AppCompatActivity, T : DIAware {
    return lazy {
        ViewModelProvider(this, direct.instance()).get(VM::class.java)
    }
}

inline fun <reified VM : AndroidViewModel, T> T.provideViewModel(): Lazy<VM>
        where T : Fragment, T : DIAware {
    return lazy {
        ViewModelProvider(this, direct.instance()).get(VM::class.java)
    }
}

inline fun <reified VB : ViewBinding> AppCompatActivity.provideViewBinding(
    crossinline bindingInflater: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater(LayoutInflater.from(applicationContext))
    }
}

fun View.setBottomPadding(paddingBottom: Int) {
    setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
}

fun View.setBottomMargin(marginBottom: Int) {
    val layoutParams = layoutParams as ViewGroup.MarginLayoutParams
    layoutParams.bottomMargin = marginBottom
    setLayoutParams(layoutParams)
    requestLayout()
}

fun EditText.showKeyboard() {
    requestFocus()
    val imm: InputMethodManager? =
        context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.attachPhoneFormatter() {
    val editModeId = R.id.editModeId
    val previousLengthId = R.id.previousLengthId
    addTextChangedListener(
        { text, start, count, after ->
            setTag(previousLengthId, start)
        },
        { _, _, _, _ ->
        },
        {
            val phone = StringBuilder(it?.toString()?.replace(" ", "") ?: "")
            phone.apply {
                var inEditMode: Boolean = getTag(editModeId) as? Boolean ?: false
                val previousLength: Int = getTag(previousLengthId) as Int
                if (length in 3..5 && !inEditMode && length >= previousLength) {
                    setTag(editModeId, true)
                    phone.insert(2, " ")
                    it?.clear()
                    it?.append(phone)
                    setText(phone)
                    setSelection(phone.length)
                    setTag(editModeId, false)
                }
                if (length >= 6 && !inEditMode && length >= previousLength) {
                    setTag(editModeId, true)
                    if (phone[2] != ' ')
                        phone.insert(2, " ")
                    phone.insert(6, " ")
                    it?.clear()
                    it?.append(phone)
                    setText(phone)
                    setSelection(phone.length)
                    setTag(editModeId, false)
                }
            }
        })
}

fun EditText.attachPhoneValidator(validatingResult: (Boolean) -> Unit) {
    addTextChangedListener {
        var phone = it?.toString()?.replace(" ", "") ?: ""
        val operatorsRegex =
            context.resources.getStringArray(R.array.ua_operators).let { operators ->
                operators.joinToString("|")
            }
        val validator = "^\\d*($operatorsRegex)\\d{7}"
        validatingResult(phone.matches(validator.toRegex()))
    }
}

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}