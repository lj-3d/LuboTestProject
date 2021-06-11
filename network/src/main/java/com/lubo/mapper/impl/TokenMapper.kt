package com.lubo.mapper.impl

import com.lubo.base.auth.models.RefreshTokenResponse
import com.lubo.mapper.base.BaseNetToEntityMapper

class TokenMapper : BaseNetToEntityMapper<RefreshTokenResponse, Boolean>() {

    override fun mapTo(dataModel: RefreshTokenResponse): Boolean {
        return true
    }

}