/*
 * Dialogs.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * This extension show material dialog
 */
fun Context.materialDialog(
    title: String,
    message: String,
    textNegativeButton: String,
    textPositiveButton: String,
    onClick: () -> Unit,
) = MaterialAlertDialogBuilder(this)
    .setTitle(title)
    .setMessage(message)
    .setNegativeButton(textNegativeButton) { dialog, _ ->
        dialog.dismiss()
    }
    .setPositiveButton(textPositiveButton) { dialog, _ ->
        onClick()
        dialog.dismiss()
    }
    .show()
