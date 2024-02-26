/*
 * ViewVisibility.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.view.View

/**
 * Valid if not visible make visible the view
 */
fun View.show(): View {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return this
}

/**
 * Validates if true gone the view
 * @param visible of [Boolean]
 */
fun View.progressVisibility(visible: Boolean) =
    if (visible) visibility = View.VISIBLE else visibility = View.GONE

/**
 * Validates if true gone the view
 * @param visible of [Boolean]
 */
fun View.layoutVisibility(visible: Boolean) =
    if (visible) visibility = View.GONE else visibility = View.VISIBLE

