package com.lubo.impl.network.auth

import com.lubo.mapper.BaseMapper

class AuthMapper : BaseMapper<Any, Boolean>() {

    override fun mapTo(dataModel: Any): Boolean {
        return true
    }

}