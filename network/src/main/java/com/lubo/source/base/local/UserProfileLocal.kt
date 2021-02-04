package com.lubo.source.base.local

interface UserProfileLocal {

    fun getToken(): String

    fun getRefreshToken(): String

}