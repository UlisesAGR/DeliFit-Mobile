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
 * Valid if not invisible make invisible the view
 */
fun View.hide(): View {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
    return this
}

/**
 * Valid if not gone make gone the view
 */
fun View.gone(): View {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
    return this
}

/**
 * Validates if true gone the view
 * @param visible of [Boolean]
 */
fun View.visibility(visible: Boolean) = if (visible) visibility = View.VISIBLE else visibility = View.GONE

/**
 * Validates empty state
 */
fun View.setRecyclerViewVisibility(itemCount: Int): View {
    visibility =
        if (itemCount == 0) {
            View.GONE
        } else {
            View.VISIBLE
        }
    return this
}

/**
 * Validates empty state
 */
fun View.setEmptyStateVisibility(itemCount: Int): View {
    visibility =
        if (itemCount == 0) {
            View.VISIBLE
        } else {
            View.GONE
        }
    return this
}
