package com.lubo.repository.base

interface AuthRepository {

    suspend fun auth(phoneNumber: String)

    suspend fun resendCodeAsync(phoneNumber: String)

    suspend fun refreshAsync(refreshToken: String)

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int)

}