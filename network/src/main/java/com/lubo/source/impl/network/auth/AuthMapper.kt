package com.lubo.source.impl.network.auth

import com.lubo.source.mapper.BaseMapper

class AuthMapper : BaseMapper<Any, Boolean>() {

    override fun mapTo(dataModel: Any): Boolean {
        return true
    }

}