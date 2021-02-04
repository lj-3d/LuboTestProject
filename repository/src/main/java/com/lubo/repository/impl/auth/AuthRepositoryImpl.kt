package com.lubo.repository.impl.auth

import com.lubo.repository.base.AuthRepository
import com.lubo.source.base.network.ApiResult
import com.lubo.source.base.network.auth.AuthNetSource
import com.lubo.source.impl.network.auth.AuthMapper
import com.lubo.source.impl.network.auth.TokenMapper

class AuthRepositoryImpl(
    private val authNetSource: AuthNetSource,
    private val authMapper: AuthMapper,
    private val tokenMapper: TokenMapper
) : AuthRepository {
    override suspend fun auth(phoneNumber: String) {
        when (val result = authNetSource.auth(phoneNumber)) {
            is ApiResult.Success -> {
                println("auth -> Success ${result.data}")
            }
            is ApiResult.Error -> {
                println(
                    "auth -> ${result.exception}"
                )
            }
        }
    }

    override suspend fun resendCodeAsync(phoneNumber: String) {
        authNetSource.resendCodeAsync(phoneNumber)
    }

    override suspend fun refreshAsync(refreshToken: String) {
        authNetSource.refreshAsync(refreshToken)
    }

    override suspend fun verifyCodeAsync(
        phoneNumber: String,
        code: Int
    ) {
        authNetSource.verifyCodeAsync(
            phoneNumber,
            code
        )
    }
}