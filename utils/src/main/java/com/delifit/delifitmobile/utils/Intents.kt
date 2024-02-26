/*
 * Intents.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner

/**
 * Override on back method
 */
fun OnBackPressedDispatcher.onBackPressedHandler(
    owner: LifecycleOwner,
    onClick: () -> Unit,
) {
    this.addCallback(
        owner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                onClick()
            }
        },
    )
}
