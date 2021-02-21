package com.lubo.presentation.base

import android.graphics.Rect
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.lubo.core.listener.KeyBoardState
import com.lubo.core.listener.KeyboardStateListener
import com.lubo.presentation.R
import kotlinx.android.synthetic.main.auth_activity.*
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI


abstract class BaseActivity<AndroidVModel : BaseViewModel> : AppCompatActivity(), DIAware {

    override val di by closestDI()

    val errorDialogFragment by lazy {
        ErrorDialogFragment()
    }

    protected abstract val viewBinding: ViewBinding?
    abstract val viewModel: AndroidVModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding?.root)
    }

    fun setOnKeyboardChangeListener(action: (state: KeyBoardState, keyboardHeight: Int) -> Unit) {
        val listener = object : KeyboardStateListener {
            override fun onKeyboardStateChange(keyBoardState: KeyBoardState, keyboardHeight: Int) {
                action(keyBoardState, keyboardHeight)
            }
        }
        attachKeyboardChangeListener(listener)
    }

    private fun attachKeyboardChangeListener(keyboardStateListener: KeyboardStateListener) {
        // Threshold for minimal keyboard height.
        val minKeyboardHeightPx = 150
        val decorView = this.window.decorView
        decorView.viewTreeObserver.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            private val windowVisibleDisplayFrame: Rect = Rect()
            private var lastVisibleDecorViewHeight = 0
            override fun onGlobalLayout() {
                // Retrieve visible rectangle inside window.
                decorView.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame)
                val visibleDecorViewHeight: Int = windowVisibleDisplayFrame.height()

                // Decide whether keyboard is visible from changing decor view height.
                if (lastVisibleDecorViewHeight != 0) {
                    if (lastVisibleDecorViewHeight > visibleDecorViewHeight + minKeyboardHeightPx) {
                        // Calculate current keyboard height (this includes also navigation bar height when in fullscreen mode).
                        val currentKeyboardHeight: Int =
                            decorView.height - windowVisibleDisplayFrame.bottom
                        // Notify listener about keyboard being shown.
                        keyboardStateListener.onKeyboardStateChange(
                            KeyBoardState.OPENED,
                            currentKeyboardHeight
                        )
                    } else if (lastVisibleDecorViewHeight + minKeyboardHeightPx < visibleDecorViewHeight) {
                        // Notify listener about keyboard being hidden.
                        keyboardStateListener.onKeyboardStateChange(
                            KeyBoardState.CLOSED,
                            0
                        )
                    }
                }
                // Save current decor view height for the next call.
                lastVisibleDecorViewHeight = visibleDecorViewHeight
            }
        })
    }

    fun addFragment(fragmentPair: Pair<BaseFragment<*>, Bundle?>) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentsContainer, fragmentPair.first.apply {
                this.arguments = fragmentPair.second
            }).commitAllowingStateLoss()

    }

    fun replaceFragment(fragmentPair: Pair<BaseFragment<*>, Bundle?>) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentsContainer, fragmentPair.first.apply {
                this.arguments = fragmentPair.second
            }).commitAllowingStateLoss()
    }

    fun popFragmentStack() {
        supportFragmentManager.popBackStack()
    }

    fun popFragmentStackOrFinish() {
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    fun showErrorDialog(title: String = "", message: String, onDismissClick: () -> Unit) {
        if (errorDialogFragment.isVisible) {
            errorDialogFragment.dismiss()
        }
        errorDialogFragment.setTitle(
            if (title.isNullOrEmpty())
                getString(R.string.error_title) else title
        )
        errorDialogFragment.setMessage(message)
        errorDialogFragment.setOnDismissClick(onDismissClick)
        errorDialogFragment.show(supportFragmentManager, errorDialogFragment::class.java.simpleName)
    }
}