package com.lubo.network.base.network

data class BaseResponse<T>(val code: Int, val responseBody: T?)