package com.lubo.repository.result

sealed class UiResult<out T : Any>() {
    data class Error(val exception: Exception) : UiResult<Nothing>()
    data class Success<out T : Any>(val data: T) : UiResult<T>()
}