package com.lubo.network.base.network

import retrofit2.Response

object ResponseHandler {

    fun <T> wrapResponse(response: Response<T>): BaseResponse<T> {
        return try {
            BaseResponse(response.code(), response.body())
        } catch (exception: Exception) {
            BaseResponse(response.code(), response.body())
        }
    }


}