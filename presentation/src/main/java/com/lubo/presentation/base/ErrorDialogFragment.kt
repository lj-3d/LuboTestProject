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

    private var title: String = ""
    private var message: String = ""
    private var onDismissClick: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.error_dialog_fragment, container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtDialogTitle = view.findViewById(R.id.txtErrorTitle)
        txtDialogMessage = view.findViewById(R.id.txtErrorMessage)
        btnDialogUnderstood = view.findViewById(R.id.btnUnderstood)

        txtDialogTitle?.text = title
        txtDialogMessage?.text = message
        btnDialogUnderstood?.setOnClickListener {
            this.onDismissClick?.invoke()
            dismiss()
        }
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun setOnDismissClick(onDismissClick: () -> Unit) {
        this.onDismissClick = onDismissClick
    }

}