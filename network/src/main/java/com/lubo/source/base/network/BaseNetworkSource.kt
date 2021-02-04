package com.lubo.source.base.network

import com.lubo.source.base.network.exceptions.ApiException
import retrofit2.Response

abstract class BaseNetworkSource {

    protected suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): ApiResult<T> {
        val response: Response<T>
        try {
            response = call()
        } catch (exception: Exception) {
            return ApiResult.Error(exception)
        }

        return if (response.isSuccessful) {
            ApiResult.Success(response.code(), response.body()!!)
        } else {
            ApiResult.Error(
                ApiException(response.code(), response.message())
            )
        }
    }


//    private fun handleErrorType(exception: Exception): ApiResult.Error {
//        if (exception is HTTPException) {
//            return ApiResult.Error(errorCode = exception.statusCode, )
//        } else {
//
//        }
//    }


}