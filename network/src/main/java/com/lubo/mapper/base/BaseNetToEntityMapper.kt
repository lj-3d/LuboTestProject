package com.lubo.mapper.base

abstract class BaseNetToEntityMapper<Network : Any, Entity : Any> {

    open fun mapTo(dataModel: Network): Entity {
        throw IllegalStateException("Not implemented!")
    }

    open fun mapFrom(dataModel: Entity): Network {
        throw IllegalStateException("Not implemented!")
    }

    fun mapTo(dataModel: List<Network>): List<Entity> = dataModel.map { mapTo(it) }

    fun mapFrom(viewModel: List<Entity>): List<Network> =
        viewModel.map { mapFrom(it) }

}