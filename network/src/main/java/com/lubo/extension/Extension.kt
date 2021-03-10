package com.lubo.extension

import com.lubo.base.network.ApiResult

fun <T : Any> ApiResult<T>.handleResponse(
    onSuccess: (apiResult: ApiResult<T>) -> Unit,
    onError: ((exception: Exception) -> Unit)? = null
) {
    when (this) {
        is ApiResult.Success -> {
            onSuccess(this)
        }
        is ApiResult.Error -> {
            onError?.invoke(exception)
        }
    }
}

fun <T : Any> ApiResult<T>.handleResponse(
    onSuccess: (apiResult: ApiResult<T>) -> Unit
) = handleResponse(onSuccess, null)