package com.lubo.repository.base

import com.lubo.repository.result.UiResult

interface AuthRepository : BaseRepository {

    suspend fun auth(phoneNumber: String): UiResult<Unit>

    suspend fun resendCodeAsync(phoneNumber: String)

    suspend fun refreshAsync(refreshToken: String)

    suspend fun verifyCodeAsync(phoneNumber: String, code: Int)

}