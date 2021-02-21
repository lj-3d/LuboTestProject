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
import kotlin.math.min


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

inline fun <reified VB : ViewBinding> Fragment.provideViewBinding(
    crossinline bindingInflater: (LayoutInflater) -> VB
): Lazy<VB> {
    return lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater(LayoutInflater.from(activity?.applicationContext))
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

fun EditText.getPhoneTextWithoutSpaces(): String {
    return "+380" + text.toString().replace(" ", "")
}

fun EditText.attachPhoneFormatter() {
    val editModeId = R.id.editModeId
    val previousLengthId = R.id.previousLengthId
    addTextChangedListener(
        { _, start, _, _ ->
            setTag(previousLengthId, start)
        },
        { _, _, _, _ ->

        },
        {
            val beginZeroRegex = "^0+".toRegex()
            val phone = (it?.toString()?.replace(" ", "") ?: "")
            val phoneZeroFormatted = phone.replace(beginZeroRegex, "")
            val phoneBuilder = StringBuilder(phoneZeroFormatted)
            phoneBuilder.apply {
                val inEditMode: Boolean = getTag(editModeId) as? Boolean ?: false
                val previousLength: Int = getTag(previousLengthId) as Int
                if (!inEditMode) {
                    if (matches(beginZeroRegex) || phone.matches(beginZeroRegex)) {
                        onEditPhone {
                            setText(replace(beginZeroRegex, ""))
                        }
                    }
                    if (length in 3..5 && length >= previousLength) {
                        onEditPhone {
                            insert(2, " ")
                            setText(this)
                            setSelection(
                                min(
                                    length,
                                    this@attachPhoneFormatter.length()
                                )
                            )
                        }
                    }
                    if (length >= 6 && length >= previousLength) {
                        onEditPhone {
                            if (this[2] != ' ')
                                insert(2, " ")
                            insert(6, " ")
                            setText(this)
                            setSelection(
                                min(
                                    length,
                                    this@attachPhoneFormatter.length()
                                )
                            )
                        }
                    }
                }
            }
        })
}

fun EditText.onEditPhone(onEditPhone: () -> Unit) {
    val editModeId = R.id.editModeId
    setTag(editModeId, true)
    onEditPhone()
    setTag(editModeId, false)
}

fun EditText.attachPhoneValidator(validatingResult: (Boolean) -> Unit) {
    addTextChangedListener {
        val phone = it?.toString()?.replace(" ", "") ?: ""
        val operatorsRegex =
            context.resources.getStringArray(R.array.ua_operators).joinToString("|")
        val validator = "^\\d*($operatorsRegex)\\d{7}"
        validatingResult(phone.matches(validator.toRegex()))
    }
}

fun SnapHelper.getSnapPosition(recyclerView: RecyclerView): Int {
    val layoutManager = recyclerView.layoutManager ?: return RecyclerView.NO_POSITION
    val snapView = findSnapView(layoutManager) ?: return RecyclerView.NO_POSITION
    return layoutManager.getPosition(snapView)
}