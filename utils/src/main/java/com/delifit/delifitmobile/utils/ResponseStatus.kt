/*
 * ResponseDatabase.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.utils

sealed class ResponseDatabase<T> {
    class Success<T>(val data: T?) : ResponseDatabase<T>()

    class Error<T>(val message: String?) : ResponseDatabase<T>()
}
