package com.lubo.repository.impl

import android.accounts.NetworkErrorException
import com.lubo.base.network.auth.AuthNetSource
import com.lubo.impl.network.auth.AuthMapper
import com.lubo.impl.network.auth.TokenMapper
import com.lubo.repository.base.AuthRepository
import com.lubo.repository.mapper.UiResultMapper
import com.lubo.repository.result.UiResult

internal class AuthRepositoryImpl(
    private val authNetSource: AuthNetSource,
    private val authMapper: AuthMapper,
    private val tokenMapper: TokenMapper,
    private val uiResultMapper: UiResultMapper
) : AuthRepository {
    override suspend fun auth(phoneNumber: String): UiResult<Unit> {
//        return authNetSource.auth(phoneNumber).han .mapToUiResult(uiResultMapper).
        return UiResult.Error(NetworkErrorException())
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

