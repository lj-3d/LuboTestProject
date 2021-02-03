package com.lubo.source.base.network

import com.lubo.source.base.network.authService.AuthService

class NetServices {

    companion object {
        val authService: AuthService = RestClient.retrofit.create(AuthService::class.java)
    }


}