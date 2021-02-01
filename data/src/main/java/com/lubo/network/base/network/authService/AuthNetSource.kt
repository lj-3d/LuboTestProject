package com.lubo.network.base.network.authService

import com.lubo.network.base.network.BaseResponse
import com.lubo.network.base.network.authService.models.RefreshTokenResponse

interface AuthNetSource {

    suspend fun auth(phoneNumber: String): BaseResponse<Unit>

    suspend fun resendCodeAsync(phoneNumber: String): BaseResponse<Unit>

    suspend fun refreshAsync(refreshToken: String): BaseResponse<RefreshTokenResponse>

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int): BaseResponse<RefreshTokenResponse>

//    private val authService = RestClient.getClient().create(AuthService::class.java)
//
//    suspend fun auth() = authService.authAsync()
//
//    suspend fun verifyCodeAsync(phoneNumber: String, code: Int) =
//        authService.verifyCodeAsync(phoneNumber, code)
//
//    suspend fun resendCodeAsync(phoneNumber: String) = authService.resendCodeAsync(phoneNumber)
//
//    suspend fun refreshAsync(refreshToken: String) = authService.refreshAsync(refreshToken)
}