package com.lubo.data.extension

import com.lubo.RepoResult
import com.lubo.base.ApiResult
import com.lubo.base.BaseNetModel
import com.lubo.entity.BaseEntity
import com.lubo.mapper.base.BaseNetToEntityMapper

fun <NetworkModel : BaseNetModel, Entity : BaseEntity> ApiResult<NetworkModel>
        .mapToEntityResult(mapper: BaseNetToEntityMapper<NetworkModel, Entity>): RepoResult<Entity> {
    return return when (this) {
        is ApiResult.Success -> {
            RepoResult.Success(mapper.mapTo(data).also {
                it.code = apiCode
            })
        }
        is ApiResult.Error -> {
            RepoResult.Error(exception)
        }
        else -> {
            TODO("RepoResultMapper unhandled sealed class!!!")
        }
    }
}

