package com.lubo.source.impl.network

import com.lubo.source.base.network.auth.AuthService

class NetServices {

    companion object {
        val authService: AuthService = RestClient.retrofit.create(
            AuthService::class.java)
    }


}