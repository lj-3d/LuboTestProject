package com.lubo.repository.base

interface ErrorHandler {

    fun onReceiveError(exception: Exception)

}