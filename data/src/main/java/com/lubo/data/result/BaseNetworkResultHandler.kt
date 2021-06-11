package com.lubo.data.result

import com.lubo.RepoResult
import com.lubo.base.ApiResult

open class BaseNetworkResultHandler {

    fun <T : Any> mapTo(apiResult: ApiResult<T>): RepoResult<T> {
        return when (apiResult) {
            is ApiResult.Success -> {
                RepoResult.Success(apiResult.data)
            }
            is ApiResult.Error -> {
                RepoResult.Error(apiResult.exception)
            }
            else -> {
                TODO("RepoResultMapper unhandled sealed class!!!")
            }
        }
    }

}