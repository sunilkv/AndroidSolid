package com.funandearn.admin.utils

sealed class    Resource<T>(
    val data: T? = null,
    val message: String? = null,
val errorCode:String ?= null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String,errorCode:String? =null, data: T? = null) : Resource<T>(data, message,errorCode)
}
