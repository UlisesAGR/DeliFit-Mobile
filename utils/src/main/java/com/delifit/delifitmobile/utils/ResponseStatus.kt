/*
 * ResponseDatabase.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.utils

sealed class ResponseStatus<T> {
    class Loading<T> : ResponseStatus<T>()

    data class Success<T>(val data: T?, val code: Int = 0) : ResponseStatus<T>()

    data class Error<T>(val message: String?, val code: Int = 0) : ResponseStatus<T>()
}
