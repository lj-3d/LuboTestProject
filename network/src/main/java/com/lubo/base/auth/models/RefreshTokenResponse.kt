package com.lubo.base.auth.models

import com.google.gson.annotations.SerializedName

data class RefreshTokenResponse(
    @SerializedName("token")
    val token: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)