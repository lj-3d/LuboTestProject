package com.lubo.source.base.network.exceptions

class ApiException(val code: Int, override val message: String) : Exception() {

}