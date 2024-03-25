/*
 * ResponseHandler.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.network.utils

import com.delifit.delifitmobile.core.data.network.response.ErrorResponse
import com.delifit.delifitmobile.core.domain.model.FailureData
import com.delifit.delifitmobile.utils.Constants
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

fun <R, T> Response<R>.toResult(action: R.() -> T) = toResource(this, action)

private fun <R, T> toResource(
    it: Response<R>,
    action: R.() -> T,
): Resource<T> =
    if (it.isSuccessful) {
        it.body()?.run {
            Resource.Success(action())
        } ?: Resource.Failure(
            status = it.code(),
            stringCode = Constants.EMPTY_BODY_RESPONSE_CODE,
            details = Constants.GENERIC_ERROR_HTTP,
        )
    } else {
        val (stringCode, type, detail, moreInfo) = parseFailureResponse(it.code(), it.errorBody())
        Resource.Failure(
            status = it.code(),
            stringCode = stringCode,
            details = detail,
            moreInfo = moreInfo,
            type = type,
        )
    }

internal fun parseFailureResponse(
    errorCode: Int,
    errorResponseBody: ResponseBody?,
): FailureData {
    var stringCode: String = errorCode.toString()
    var detail: String = Constants.GENERIC_ERROR_HTTP
    var moreInfo: String? = null
    var type: String? = null
    val errorBody: String? = errorResponseBody?.toString()
    errorBody?.let {
        try {
            val errorResponse = Gson().fromJson(errorBody, ErrorResponse::class.java)
            errorResponse.type?.let {
                type = it
            }
            errorResponse.code?.let {
                stringCode = it
            }
            errorResponse.details?.let {
                detail = it
            }
            moreInfo = errorResponse.moreInfo
        } catch (exception: Exception) {
            detail = exception.message ?: (Constants.JSON_EXCEPTION + ErrorResponse::class.java)
        }
    }
    return FailureData(stringCode, type, detail, moreInfo)
}

fun Throwable.parseError(): UseCaseException.GenericException =
    when (this) {
        is UnknownHostException, is ConnectException, is SocketException ->
            UseCaseException.GenericException(Constants.RED_CODE, Constants.RED_ERROR)

        is SocketTimeoutException, is TimeoutException ->
            UseCaseException.GenericException(Constants.TIMEOUT_CODE, Constants.TIMEOUT_ERROR)

        is HttpException ->
            UseCaseException.GenericException(Constants.HTTP_CODE, Constants.HTTP_ERROR)

        else ->
            UseCaseException.GenericException(Constants.GENERIC_CODE, Constants.GENERIC_ERROR)
    }
