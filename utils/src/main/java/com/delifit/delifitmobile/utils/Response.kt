/*
 * Response.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

fun <R, T> Response<R>.toResult(
    action: R.() -> T,
) = toResource(this, action)

private fun <R, T> toResource(
    it: Response<R>,
    action: R.() -> T,
): Resource<T> {
    return if (it.isSuccessful) {
        it.body()?.run {
            Resource.Success(action())
        } ?: Resource.Failure(
            status = it.code(),
            message = it.message(),
            GENERIC_ERROR,
        )
    } else {
        Resource.Failure(
            status = it.code(),
            message = it.message(),
            GENERIC_ERROR,
        )
    }
}

sealed class Resource<out T>(
    val status: Int,
    val data: T? = null,
    val message: String? = "",
    val messageDefault: String? = "",
) {
    class Success<T>(
        data: T,
    ) : Resource<T>(
        status = 200,
        data = data,
    )

    class Failure<T>(
        status: Int,
        message: String,
        messageDefault: String,
    ) : Resource<T>(
        status = status,
        message = message,
        messageDefault = messageDefault,
    )

    fun isSuccessful(): Boolean =
        status in 200..300
}

fun Throwable.parseError(): UseCaseException.GenericException =
    when (this) {
        is UnknownHostException, is ConnectException, is SocketException ->
            UseCaseException.GenericException(RED_CODE, RED_ERROR)

        is SocketTimeoutException, is TimeoutException ->
            UseCaseException.GenericException(TIMEOUT_CODE, TIMEOUT_ERROR)

        is HttpException ->
            UseCaseException.GenericException(HTTP_CODE, HTTP_ERROR)

        else ->
            UseCaseException.GenericException(GENERIC_CODE, GENERIC_ERROR)
    }

sealed class UseCaseException : kotlin.Exception() {
    class GenericException(
        val code: Int = 0,
        val errorMessage: String = "",
    ) : Exception(errorMessage) {
        var serverCode: Int = 0
        var serverMessage: String = ""
    }
}

const val RED_CODE = 101
const val RED_ERROR = "Revise su conexion a internet"
const val TIMEOUT_CODE = 102
const val TIMEOUT_ERROR = "Tiempo de espera agotado"
const val BAD_RESPONSE_CODE = 444
const val BAD_RESPONSE_ERROR = "Mala respuesta del servidor"
const val HTTP_CODE = 503
const val HTTP_ERROR = "Hay problemas con el serividor, intentelo mas tarde"
const val GENERIC_CODE = 500
const val GENERIC_ERROR = "Hay problemas con el serividor, intentelo mas tarde"
