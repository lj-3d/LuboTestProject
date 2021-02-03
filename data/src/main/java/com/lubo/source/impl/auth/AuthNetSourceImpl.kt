package com.lubo.source.impl.auth

import com.google.gson.JsonObject
import com.lubo.source.base.network.ApiResult
import com.lubo.source.base.network.BaseNetworkSource
import com.lubo.source.base.network.EmptyNetModel
import com.lubo.source.base.network.NetServices
import com.lubo.source.base.network.authService.AuthNetSource
import com.lubo.source.base.network.authService.models.RefreshTokenResponse
import okhttp3.RequestBody.Companion.toRequestBody

class AuthNetSourceImpl : AuthNetSource, BaseNetworkSource() {

    private val authService = NetServices.authService

    override suspend fun auth(phoneNumber: String): ApiResult<EmptyNetModel> {
        val json = JsonObject()
        json.addProperty("phoneNumber", phoneNumber)
        println("api service -> $authService $json")
        return apiRequest { authService.authAsync(json.toString().toRequestBody()) }

    }

    override suspend fun resendCodeAsync(phoneNumber: String): ApiResult<EmptyNetModel> {
        return apiRequest { authService.resendCodeAsync(phoneNumber) }

    }

    override suspend fun refreshAsync(refreshToken: String): ApiResult<RefreshTokenResponse> {
        return apiRequest { authService.refreshAsync(refreshToken) }
    }

    override suspend fun verifyCodeAsync(
        phoneNumber: String,
        code: Int
    ): ApiResult<RefreshTokenResponse> {
        return apiRequest { authService.verifyCodeAsync(phoneNumber, code) }
    }
}