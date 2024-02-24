/*
 * System.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2024. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

/**
 *This function will validate if you have the permissions
 */
fun Context.checkPermission(permission: String): Boolean =
    (
        ContextCompat.checkSelfPermission(
            this,
            permission,
        ) == PackageManager.PERMISSION_GRANTED
    )

/**
 * This function requests the permission that you request
 */
fun FragmentActivity.requestPermission(
    permission: Array<String>,
    code: Int,
) {
    ActivityCompat.requestPermissions(
        this,
        permission,
        code,
    )
}
