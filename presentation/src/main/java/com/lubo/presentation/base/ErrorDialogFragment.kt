package com.lubo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.lubo.presentation.R


class ErrorDialogFragment : BottomSheetDialogFragment() {

    private var txtDialogTitle: AppCompatTextView? = null
    private var txtDialogMessage: AppCompatTextView? = null
    private var btnDialogUnderstood: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.error_dialog_fragment, container,
            false
        ).also {
            txtDialogTitle = it.findViewById(R.id.txtErrorTitle)
            txtDialogMessage = it.findViewById(R.id.txtErrorMessage)
            btnDialogUnderstood = it.findViewById(R.id.btnUnderstood)
            setOnDismissClick {  }
        }
    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    fun setTitle(title: String) {
        txtDialogTitle?.text = title
    }

    fun setMessage(message: String) {
        txtDialogMessage?.text = message
    }

    fun setOnDismissClick(onDismissClick: () -> Unit) {
        btnDialogUnderstood?.setOnClickListener {
            onDismissClick()
            dismiss()
        }
    }

}