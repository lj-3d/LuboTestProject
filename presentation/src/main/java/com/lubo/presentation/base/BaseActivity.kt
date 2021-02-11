package com.lubo.presentation.base

import android.graphics.Rect
import android.os.Bundle
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.lubo.core.listener.KeyBoardState
import com.lubo.core.listener.KeyboardStateListener
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI


abstract class BaseActivity<AndroidVModel : BaseViewModel> : AppCompatActivity(), DIAware {

    override val di by closestDI()

    protected abstract val viewBinding: ViewBinding?
    protected abstract val viewModel: AndroidVModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding?.root)
    }

    protected fun setOnKeyboardChangeListener(action: (state: KeyBoardState, keyboardHeight: Int) -> Unit) {
        val listener = object : KeyboardStateListener {
            override fun onKeyboardStateChange(keyBoardState: KeyBoardState, keyboardHeight: Int) {
                action(keyBoardState, keyboardHeight)
            }
        }
        attachKeyboardChangeListener(listener)
    }

    private fun attachKeyboardChangeListener(keyboardStateListener: KeyboardStateListener) {
        // Threshold for minimal keyboard height.
        val MIN_KEYBOARD_HEIGHT_PX = 150
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
                    if (lastVisibleDecorViewHeight > visibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX) {
                        // Calculate current keyboard height (this includes also navigation bar height when in fullscreen mode).
                        val currentKeyboardHeight: Int =
                            decorView.height - windowVisibleDisplayFrame.bottom
                        // Notify listener about keyboard being shown.
                        keyboardStateListener.onKeyboardStateChange(
                            KeyBoardState.OPENED,
                            currentKeyboardHeight
                        )
                    } else if (lastVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX < visibleDecorViewHeight) {
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
}