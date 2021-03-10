package com.lubo.repository.mapper

import com.lubo.base.network.ApiResult
import com.lubo.repository.result.UiResult

class UiResultMapper {

    fun <T : Any> mapTo(apiResult: ApiResult<T>): UiResult<T> {
        return when (apiResult) {
            is ApiResult.Success -> {
                UiResult.Success(apiResult.data)
            }
            is ApiResult.Error -> {
                UiResult.Error(apiResult.exception)
            }
        }
    }

}