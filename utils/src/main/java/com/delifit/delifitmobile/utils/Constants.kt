/*
 * Constants.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

object Constants {
    const val EMPTY_INT = 0
    const val EMPTY_STRING = ""
    const val EMPTY_DOUBLE = 0.0
    const val ZOOM = 5f
    const val DURATION = 2000
    const val ANIMATION_ALFA_HIDDEN = 0f
    const val ANIMATION_ALFA_VISIBLE = 1f

    const val RED_CODE = 101
    const val RED_ERROR = "Revise su conexion a internet"
    const val TIMEOUT_CODE = 102
    const val TIMEOUT_ERROR = "Tiempo de espera agotado"
    const val HTTP_CODE = 503
    const val HTTP_ERROR = "Hay problemas con el serividor, intentelo mas tarde"
    const val GENERIC_CODE = 500
    const val GENERIC_ERROR = "Por el momento no podemos realizar esta accion, intenalo mas tarde"
    const val GENERIC_ERROR_HTTP = "Hay problemas de comunicacion con el servidor"
    const val EMPTY_BODY_RESPONSE_CODE = "emptyBody"
    const val JSON_EXCEPTION = "JSON value is not valid for this object: "
}
