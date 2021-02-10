package com.lubo.local.impl

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.edit
import com.lubo.local.base.Constants
import com.lubo.local.base.UserProfileLocalSource

internal class UserProfileLocalSourceImpl(private val sharedPreferences: SharedPreferences) :
    UserProfileLocalSource {

    override fun getToken(): String? {
        return sharedPreferences.getString(Constants.SP_TOKEN_KEY, "")
    }

    override fun getRefreshToken(): String? {
        return sharedPreferences.getString(Constants.SP_REFRESH_TOKEN_KEY, "")
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun writeToken(token: String) = sharedPreferences.edit {
        putString(Constants.SP_TOKEN_KEY, token)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun writeRefreshToken(refreshToken: String) = sharedPreferences.edit {
        putString(Constants.SP_REFRESH_TOKEN_KEY, refreshToken)
    }

}