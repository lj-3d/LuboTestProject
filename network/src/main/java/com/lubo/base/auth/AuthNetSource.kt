package com.lubo.base.auth

import com.lubo.base.ApiResult
import com.lubo.base.EmptyNetModel
import com.lubo.base.auth.models.AuthDataModel
import com.lubo.base.auth.models.RefreshTokenResponse

interface AuthNetSource {

    suspend fun auth(phoneNumber: String): ApiResult<AuthDataModel>

    suspend fun resendCodeAsync(phoneNumber: String): ApiResult<EmptyNetModel>

    suspend fun refreshAsync(refreshToken: String): ApiResult<RefreshTokenResponse>

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int): ApiResult<RefreshTokenResponse>
}