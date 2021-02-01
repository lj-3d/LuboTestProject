package com.lubo.network.impl.auth

import com.lubo.network.base.network.BaseResponse
import com.lubo.network.base.network.ResponseHandler
import com.lubo.network.base.network.RestClient
import com.lubo.network.base.network.authService.AuthNetSource
import com.lubo.network.base.network.authService.AuthService
import com.lubo.network.base.network.authService.models.RefreshTokenResponse

class AuthNetSourceImpl : AuthNetSource {

    private val authService = RestClient.getClient().create(AuthService::class.java)

    override suspend fun auth(phoneNumber: String): BaseResponse<Unit> {
        return ResponseHandler.wrapResponse(authService.authAsync(phoneNumber).await())
    }

    override suspend fun resendCodeAsync(phoneNumber: String): BaseResponse<Unit> {
        return ResponseHandler.wrapResponse(authService.resendCodeAsync(phoneNumber).await())
    }

    override suspend fun refreshAsync(refreshToken: String): BaseResponse<RefreshTokenResponse> {
        return ResponseHandler.wrapResponse(authService.refreshAsync(refreshToken).await())
    }

    override suspend fun verifyCodeAsync(
        phoneNumber: String,
        code: Int
    ): BaseResponse<RefreshTokenResponse> {
        return ResponseHandler.wrapResponse(authService.verifyCodeAsync(phoneNumber, code).await())
    }
}