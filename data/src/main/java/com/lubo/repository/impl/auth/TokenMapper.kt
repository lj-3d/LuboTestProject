package com.lubo.repository.impl.auth

import com.lubo.source.base.mapper.BaseMapper
import com.lubo.source.base.network.authService.models.RefreshTokenResponse

class TokenMapper : BaseMapper<RefreshTokenResponse, Boolean>() {

    override fun mapTo(dataModel: RefreshTokenResponse): Boolean {
        return true
    }

}