/*
 * Animation.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun View.setImageViewAnimation(animationId: Int) {
    val animation =
        AnimationUtils.loadAnimation(context, animationId)
    animation.setAnimationListener(
        object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) = Unit

            override fun onAnimationEnd(animation: Animation?) {
                this@setImageViewAnimation.clearAnimation()
            }

            override fun onAnimationStart(animation: Animation?) = Unit
        },
    )
    this.startAnimation(animation)
}
