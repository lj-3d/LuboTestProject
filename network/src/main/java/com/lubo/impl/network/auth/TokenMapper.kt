package com.lubo.impl.network.auth

import com.lubo.mapper.BaseMapper
import com.lubo.base.network.auth.models.RefreshTokenResponse

class TokenMapper : BaseMapper<RefreshTokenResponse, Boolean>() {

    override fun mapTo(dataModel: RefreshTokenResponse): Boolean {
        return true
    }

}