/*
 * Formats.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Base64
import androidx.core.content.ContextCompat
import java.io.ByteArrayOutputStream
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * Bitmap to String
 */
fun Bitmap.bitmapToString(): String? {
    val byteArrayOutputStream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream)
    val byteArray = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(byteArray, Base64.DEFAULT)
}

/**
 * String to Uri
 */
fun String.toUri(): Uri = Uri.parse(this)

/**
 * This extension format a decimal value
 * Only two zeros and convert to string
 * Return zero if is null
 */
fun Double?.decimalFormat(): String = DecimalFormat("#.00").format(this) ?: "0.00"

/**
 * This extension format a calendar date
 */
@SuppressLint("SimpleDateFormat")
fun getCalendarDate(): String =
    SimpleDateFormat("dd/MM/yyyy, HH:mm:ss")
    .format(Calendar.getInstance().time)

/**
 * Get color from colors of Res
 */
fun Context.getColors(string: Int): Int = ContextCompat.getColor(this, string)

/**
 * Get drawable from colors of Res
 */
fun Context.getDrawables(id: Int): Drawable? = ContextCompat.getDrawable(this, id)
