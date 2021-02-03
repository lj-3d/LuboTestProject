package com.lubo.repository.impl.auth

import com.lubo.source.base.mapper.BaseMapper
import com.lubo.source.base.network.BaseResponse

class AuthMapper : BaseMapper<BaseResponse<Any>, Boolean>() {

    override fun mapTo(dataModel: BaseResponse<Any>): Boolean {
        return dataModel.code == 200
    }

}