package com.lubo.repository.extension

import com.lubo.base.network.ApiResult
import com.lubo.repository.mapper.UiResultMapper
import com.lubo.repository.result.UiResult

fun <T : Any> ApiResult<T>.mapToUiResult(uiResultMapper: UiResultMapper): UiResult<T> =
    uiResultMapper.mapTo(this)
