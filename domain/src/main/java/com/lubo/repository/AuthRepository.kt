package com.lubo.repository

import com.lubo.RepoResult
import com.lubo.entity.AuthEntity

interface AuthRepository : BaseRepository {

    suspend fun auth(phoneNumber: String) : RepoResult<AuthEntity>

    suspend fun resendCodeAsync(phoneNumber: String)

    suspend fun refreshAsync(refreshToken: String)

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int)

}