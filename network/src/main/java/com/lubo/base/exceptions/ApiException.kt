package com.lubo.base.exceptions

class ApiException(val code: Int, override val message: String) : Exception() {

}