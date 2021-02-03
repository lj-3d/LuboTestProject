package com.lubo.source.base.network

import com.lubo.source.base.network.exceptions.ApiException

data class BaseResponse<T>(
    val code: Int,
    val responseBody: T?,
    val apiException: ApiException? = null


) {
    override fun toString(): String {
        return "BaseResponse(code=$code, responseBody=$responseBody, apiException=$apiException)"
    }
}