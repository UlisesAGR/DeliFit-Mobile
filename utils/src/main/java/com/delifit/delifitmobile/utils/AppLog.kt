/*
 * AppLog.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

class AppLog {
    fun exception(
        tag: Any,
        exception: Throwable,
    ) {
        if (BuildConfig.DEBUG) {
            exception(tag, exception)
        }
    }

    companion object {
        @JvmField
        val log = AppLog()
    }
}
