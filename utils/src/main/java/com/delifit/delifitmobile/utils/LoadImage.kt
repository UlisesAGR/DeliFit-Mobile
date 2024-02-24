/*
 * LoadImage.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 *This extension load image with Glide from a url
 */
fun ImageView.load(
    url: String?,
    placeholder: Int,
    errorImage: Int,
) {
    Glide.with(this)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(placeholder)
        .error(errorImage)
        .into(this)
}

/**
 *This extension load image with Glide from a uri
 */
fun ImageView.load(
    uri: Uri?,
    placeholder: Int,
    errorImage: Int,
) {
    Glide.with(this)
        .load(uri)
        .transition(DrawableTransitionOptions.withCrossFade())
        .placeholder(placeholder)
        .error(errorImage)
        .into(this)
}
