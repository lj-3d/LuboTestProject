package com.lubo.impl.network

import com.lubo.base.network.auth.AuthService

class NetServices {

    companion object {
        val authService: AuthService = RestClient.retrofit.create(
            AuthService::class.java)
    }


}