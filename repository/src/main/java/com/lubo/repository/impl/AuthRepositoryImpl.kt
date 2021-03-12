package com.lubo.repository.impl

import com.lubo.base.network.auth.AuthNetSource
import com.lubo.extension.handleResponse
import com.lubo.impl.network.auth.AuthMapper
import com.lubo.impl.network.auth.TokenMapper
import com.lubo.repository.base.AuthRepository

internal class AuthRepositoryImpl(
    private val authNetSource: AuthNetSource,
    private val authMapper: AuthMapper,
    private val tokenMapper: TokenMapper
) : AuthRepository {
    override suspend fun auth(phoneNumber: String) {
        authNetSource.auth(phoneNumber).handleResponse { _, _ ->

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

