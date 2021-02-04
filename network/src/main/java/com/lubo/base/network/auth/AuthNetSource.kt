package com.lubo.base.network.auth

import com.lubo.base.network.ApiResult
import com.lubo.base.network.EmptyNetModel
import com.lubo.base.network.auth.models.RefreshTokenResponse

interface AuthNetSource {

    suspend fun auth(phoneNumber: String): ApiResult<EmptyNetModel>

    suspend fun resendCodeAsync(phoneNumber: String): ApiResult<EmptyNetModel>

    suspend fun refreshAsync(refreshToken: String): ApiResult<RefreshTokenResponse>

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int): ApiResult<RefreshTokenResponse>
}