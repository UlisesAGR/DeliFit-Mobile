/*
 * Intents.kt
 * Created by Ulises Gonzalez on 04/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner

/**
 * This method change a new activity
 */
fun FragmentActivity.nextActivity(activity: FragmentActivity) {
    Intent(this, activity::class.java).apply {
        startActivity(this)
    }
}

/**
 * This method change a new activity with animation
 */
fun FragmentActivity.nextActivity(
    activity: FragmentActivity,
    enterAnim: Int,
    exitAnim: Int,
) {
    Intent(this, activity::class.java).apply {
        val options = ActivityOptions.makeCustomAnimation(this@nextActivity, enterAnim, exitAnim)
        startActivity(this, options.toBundle())
        // overridePendingTransition(enterAnim, exitAnim)
    }
}

/**
 * This method change a new activity and add a extra
 */
fun FragmentActivity.nextActivity(
    goToActivity: FragmentActivity,
    extras: Bundle.() -> Unit = {},
) {
    Intent(this, goToActivity::class.java).apply {
        this.putExtras(Bundle().apply(extras))
        startActivity(this)
    }
}

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
                onClick.invoke()
            }
        },
    )
}
