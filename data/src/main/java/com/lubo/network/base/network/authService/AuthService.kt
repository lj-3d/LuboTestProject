package com.lubo.network.base.network.authService

import com.lubo.network.base.network.authService.models.RefreshTokenResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @GET("/auth")
    fun authAsync(
        @Field("phoneNumber") phoneNumber: String
    ): Deferred<Response<Unit>>

    @POST("/verifyCode")
    fun verifyCodeAsync(
        @Field("phoneNumber") phoneNumber: String,
        @Field("code") code: Int
    ): Deferred<Response<RefreshTokenResponse>>

    @POST("/resendCode")
    fun resendCodeAsync(
        @Field("phoneNumber") phoneNumber: String
    ): Deferred<Response<Unit>>

    @GET("/refresh")
    fun refreshAsync(
        @Field("refreshToken") refreshToken: String
    ): Deferred<Response<RefreshTokenResponse>>
}