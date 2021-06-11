package com.lubo.mapper.impl

import com.lubo.base.auth.models.AuthDataModel
import com.lubo.entity.AuthEntity
import com.lubo.mapper.base.BaseNetToEntityMapper

class AuthMapper : BaseNetToEntityMapper<AuthDataModel, AuthEntity>() {

    override fun mapTo(dataModel: AuthDataModel): AuthEntity {
        return AuthEntity().also {
            it.ttl = dataModel.ttl
            it.message = dataModel.message
        }
    }

    override fun mapFrom(dataModel: AuthEntity): AuthDataModel {
        return super.mapFrom(dataModel)
    }

}