/*
 * ImageView.kt
 * Created by Ulises Gonzalez on 26/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.load(
    url: String?,
    error: Int,
) {
    Glide.with(this)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(android.R.drawable.progress_indeterminate_horizontal)
        .error(error)
        .into(this)
}
