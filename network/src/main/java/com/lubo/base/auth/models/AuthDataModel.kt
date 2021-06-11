package com.lubo.base.auth.models

import com.google.gson.annotations.SerializedName
import com.lubo.base.BaseNetModel

data class AuthDataModel(
    @SerializedName("ttl")
    val ttl: Int,
    @SerializedName("message")
    val message: String
) : BaseNetModel()