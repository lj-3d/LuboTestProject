package com.lubo.core.listener

interface KeyboardStateListener {

    fun onKeyboardStateChange(keyBoardState: KeyBoardState, keyboardHeight: Int)

}

enum class KeyBoardState {
    OPENED, CLOSED
}