package com.lubo.local.impl

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.edit
import com.lubo.local.base.Constants
import com.lubo.local.base.UserProfileLocalSource

class UserProfileLocalSourceImpl : UserProfileLocalSource {

    private val spManager = SharedPrefsManager.sharedPrefs!!

    override fun getToken(): String? {
        return spManager.getString(Constants.SP_TOKEN_KEY, "")
    }

    override fun getRefreshToken(): String? {
        return spManager.getString(Constants.SP_REFRESH_TOKEN_KEY, "")
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun writeToken(token: String) = spManager.edit {
        putString(Constants.SP_TOKEN_KEY, token)
    }

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun writeRefreshToken(refreshToken: String) = spManager.edit {
        putString(Constants.SP_REFRESH_TOKEN_KEY, refreshToken)
    }

}