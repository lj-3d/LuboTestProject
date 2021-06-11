package com.lubo.data.repository

import android.util.Log
import com.lubo.RepoResult
import com.lubo.base.auth.AuthNetSource
import com.lubo.data.extension.mapToEntityResult
import com.lubo.entity.AuthEntity
import com.lubo.mapper.impl.AuthMapper
import com.lubo.mapper.impl.TokenMapper
import com.lubo.repository.AuthRepository

internal class AuthRepositoryImpl(
    private val authNetSource: AuthNetSource,
    private val authMapper: AuthMapper,
    private val tokenMapper: TokenMapper
) : AuthRepository {
    override suspend fun auth(phoneNumber: String): RepoResult<AuthEntity> {
//        val result: RepoResult<AuthEntity> =
//            authNetSource.auth(phoneNumber).mapToEntityResult(authMapper)
//        when (result) {
//            is RepoResult.Success -> {
//                result.data.message?.let { Log.d("mapping result", it) }
//            }
//            is RepoResult.Error -> {
//
//            }
//        }

        return authNetSource.auth(phoneNumber).mapToEntityResult(authMapper)
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

