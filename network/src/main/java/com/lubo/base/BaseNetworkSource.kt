package com.lubo.base

import com.lubo.base.exceptions.ApiException
import retrofit2.Response

abstract class BaseNetworkSource {

    protected suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): ApiResult<T> {
        val response: Response<T>
        try {
            response = call()
            return if (response.isSuccessful) {
                ApiResult.Success(
                    response.code(),
                    response.body()!!
                )
            } else {
                ApiResult.Error(
                    ApiException(
                        response.code(),
                        response.message()
                    )
                )
            }
        } catch (exception: Exception) {
            return ApiResult.Error(exception)
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