package com.lubo.local.base

interface UserProfileLocalSource {

    fun getToken(): String?

    fun getRefreshToken(): String?

    fun writeToken(token: String)

    fun writeRefreshToken(refreshToken: String)
}