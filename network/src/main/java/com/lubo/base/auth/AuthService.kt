package com.lubo.base.auth

import com.lubo.base.EmptyNetModel
import com.lubo.base.auth.models.AuthDataModel
import com.lubo.base.auth.models.RefreshTokenResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthService {

    @POST("auth")
    suspend fun authAsync(
        @Body body: RequestBody
    ): Response<AuthDataModel>

    @POST("verifyCode")
    suspend fun verifyCodeAsync(
        @Field("phoneNumber") phoneNumber: String,
        @Field("code") code: Int
    ): Response<RefreshTokenResponse>

    @POST("resendCode")
    suspend fun resendCodeAsync(
        @Field("phoneNumber") phoneNumber: String
    ): Response<EmptyNetModel>

    @GET("refresh")
    suspend fun refreshAsync(
        @Field("refreshToken") refreshToken: String
    ): Response<RefreshTokenResponse>
}