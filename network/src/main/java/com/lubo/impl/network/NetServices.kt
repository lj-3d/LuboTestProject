package com.lubo.impl.network

import com.lubo.base.auth.AuthService

class NetServices {

    companion object {
        val authService: AuthService = RestClient.retrofit.create(
            AuthService::class.java)
    }


}