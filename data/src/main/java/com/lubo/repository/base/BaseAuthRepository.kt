package com.lubo.repository.base

import com.lubo.network.base.network.BaseResponse
import com.lubo.network.base.network.authService.models.RefreshTokenResponse

interface BaseAuthRepository {

    suspend fun auth(phoneNumber: String): BaseResponse<Unit>

    suspend fun resendCodeAsync(phoneNumber: String): BaseResponse<Unit>

    suspend fun refreshAsync(refreshToken: String): BaseResponse<RefreshTokenResponse>

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int): BaseResponse<RefreshTokenResponse>

}