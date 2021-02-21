package com.lubo.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.lubo.core.listener.KeyBoardState
import com.lubo.presentation.R
import com.lubo.presentation.custom.LuboToolbar
import com.lubo.presentation.extension.provideViewModel
import kotlinx.android.synthetic.main.auth_activity.*
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI

abstract class BaseFragment<AndroidVModel : BaseViewModel> : Fragment(), DIAware {

    override val di: DI by lazy {
        (activity as BaseActivity<*>).di
    }

    protected abstract val viewBinding: ViewBinding?

    @Suppress("UNCHECKED_CAST")
    protected val viewModel by lazy {
        (activity as BaseActivity<*>).viewModel as AndroidVModel
    }

    protected abstract fun afterViewCreated(savedInstanceState: Bundle?)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    protected fun getToolbar(): LuboToolbar? = (activity as BaseActivity<*>).toolbar

    protected fun setOnKeyboardChangeListener(
        action: (state: KeyBoardState, keyboardHeight: Int) -> Unit
    ) {
        (activity as BaseActivity<*>).setOnKeyboardChangeListener(action)
    }

    fun showErrorDialog(title: String = "", message: String, onDismissClick: () -> Unit) {
        (activity as BaseActivity<*>).showErrorDialog(title, message, onDismissClick)
    }
}