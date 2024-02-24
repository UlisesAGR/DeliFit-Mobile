/*
 * AppLog.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.util.Log

class AppLog {
    fun debug(
        tag: Any,
        message: String,
    ) {
        if (BuildConfig.DEBUG) {
            val className = tag.javaClass.simpleName
            Log.d(className, message)
        }
    }

    fun info(
        tag: Any,
        message: String,
    ) {
        if (BuildConfig.DEBUG) {
            val className = tag.javaClass.simpleName
            Log.i(className, message)
        }
    }

    fun warning(
        tag: Any,
        message: String,
    ) {
        if (BuildConfig.DEBUG) {
            val className = tag.javaClass.simpleName
            Log.w(className, message)
        }
    }

    fun error(
        tag: Any,
        message: String,
    ) {
        if (BuildConfig.DEBUG) {
            val className = tag.javaClass.simpleName
            Log.e(className, message)
        }
    }

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
