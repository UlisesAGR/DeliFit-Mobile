/*
 * UseCaseException.kt
 * Created by Ulises Gonzalez on 27/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.network

import com.delifit.delifitmobile.utils.Constants

sealed class UseCaseException : kotlin.Exception() {
    class GenericException(
        val code: Int = 0,
        val errorMessage: String = Constants.EMPTY_STRING,
        vararg val params: Any?,
    ) : Exception(errorMessage) {
        var serverCode: Int = 0
        var serverMessage: String = Constants.EMPTY_STRING
    }
}
