package com.lubo.source.impl.network.auth

import com.lubo.source.mapper.BaseMapper
import com.lubo.source.base.network.auth.models.RefreshTokenResponse

class TokenMapper : BaseMapper<RefreshTokenResponse, Boolean>() {

    override fun mapTo(dataModel: RefreshTokenResponse): Boolean {
        return true
    }

}