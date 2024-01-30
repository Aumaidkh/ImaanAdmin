package com.imaan.imaanadmin.core.utils

sealed class Result <out T>(data: T?,error: Throwable?){
    data class Success<T>(val data: T): Result<T>(data,null)
    data class Error<T>(val error: Throwable): Result<T>(null,error)
}