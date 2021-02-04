package com.lubo.mapper

abstract class BaseMapper<DataModel : Any, ViewModel : Any> {

    open fun mapTo(dataModel: DataModel): ViewModel {
        throw IllegalStateException("Not implemented!")
    }

    open fun mapFrom(dataModel: ViewModel): DataModel {
        throw IllegalStateException("Not implemented!")
    }

    fun mapTo(dataModel: List<DataModel>): List<ViewModel> = dataModel.map { mapTo(it) }

    fun mapFrom(viewModel: List<ViewModel>): List<DataModel> =
        viewModel.map { mapFrom(it) }
}