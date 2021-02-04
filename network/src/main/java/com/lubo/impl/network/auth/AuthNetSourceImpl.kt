package com.lubo.impl.network.auth

import com.google.gson.JsonObject
import com.lubo.base.network.ApiResult
import com.lubo.base.network.BaseNetworkSource
import com.lubo.base.network.EmptyNetModel
import com.lubo.impl.network.NetServices
import com.lubo.base.network.auth.AuthNetSource
import com.lubo.base.network.auth.models.RefreshTokenResponse
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