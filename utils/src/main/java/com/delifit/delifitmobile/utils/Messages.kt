/*
 * Messages.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.content.Context
import android.widget.Toast

/**
 * This extension show toast if not empty
 */
fun Context.toast(message: String) {
    if (message.isNotEmpty()) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

/**
 * This extension show toast if id is not zero
 */
fun Context.toast(messageId: Int) {
    if (messageId != 0) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
    }
}
