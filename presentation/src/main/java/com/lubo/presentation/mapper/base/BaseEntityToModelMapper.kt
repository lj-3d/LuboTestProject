package com.lubo.presentation.mapper.base

abstract class BaseEntityToModelMapper<Entity : Any, Model : Any> {

    open fun mapTo(dataModel: Entity): Model {
        throw IllegalStateException("Not implemented!")
    }

    open fun mapFrom(dataModel: Model): Entity {
        throw IllegalStateException("Not implemented!")
    }

    fun mapTo(dataModel: List<Entity>): List<Model> = dataModel.map { mapTo(it) }

    fun mapFrom(viewModel: List<Model>): List<Entity> =
        viewModel.map { mapFrom(it) }

}