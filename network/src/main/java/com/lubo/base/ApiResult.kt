package com.lubo.base

sealed class ApiResult<out T : Any> {
    data class Success<out T : Any>(val apiCode: Int = -1, val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}