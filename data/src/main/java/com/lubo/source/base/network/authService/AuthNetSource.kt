package com.lubo.source.base.network.authService

import com.lubo.source.base.network.ApiResult
import com.lubo.source.base.network.EmptyNetModel
import com.lubo.source.base.network.authService.models.RefreshTokenResponse

interface AuthNetSource {

    suspend fun auth(phoneNumber: String): ApiResult<EmptyNetModel>

    suspend fun resendCodeAsync(phoneNumber: String): ApiResult<EmptyNetModel>

    suspend fun refreshAsync(refreshToken: String): ApiResult<RefreshTokenResponse>

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int): ApiResult<RefreshTokenResponse>

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