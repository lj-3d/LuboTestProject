package com.lubo.extension

import com.lubo.base.ApiResult

fun <T : Any> ApiResult<T>.handleResponse(
    onSuccess: (apiCode: Int, data: T) -> Unit,
    onError: ((exception: Exception) -> Unit)? = null
) {
    when (this) {
        is ApiResult.Success -> {
            onSuccess(apiCode, data)
        }
        is ApiResult.Error -> {
            onError?.invoke(exception)
        }
    }
}

fun <T : Any> ApiResult<T>.handleResponse(
    onSuccess: (apiCode: Int, data: T) -> Unit
) = handleResponse(onSuccess, null)