/*
 * SetOnSafeClickListener.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.view.View
import androidx.annotation.VisibleForTesting
import com.delifit.delifitmobile.utils.SafeClick.Companion.CLICK_THRESHOLD_MS

/**
 * Creates a click listener that avoids multiple rapid clicks on
 * this view or other views implementing safe listener.
 *
 * There is no current implementation of a unique-view throttling
 * as the project will rarely need the rapid clicks to be managed
 * independently (for example, A has throttling, B has throttling,
 * but can be clicked rapidly)
 *
 * @param onClick - lambda event to be fired on click, the view
 *          on lambda is the same view that was clicked.
 */
fun View.setOnSafeClickListener(
    clickThreshold: Long = CLICK_THRESHOLD_MS,
    onClick: (v: View) -> Unit,
) {
    setOnClickListener(
        object : OnSafeClickListener(clickThreshold) {
            override fun onSafeClick(v: View) {
                onClick(v)
            }
        },
    )
}

/**
 * Convenience method for [View.setOnSafeClickListener], which due to Kotlin not
 * having Java SAM conversions, is needed if the programmer wishes to add several views
 * to one unique listener (for example, an activity that implements OnClickListener)
 *
 * @param listener - Click listener which will receive all safe click events.
 */
fun View.setOnSafeClickListener(listener: View.OnClickListener) {
    setOnSafeClickListener(CLICK_THRESHOLD_MS, listener)
}

fun View.setOnSafeClickListener(
    clickThreshold: Long,
    listener: View.OnClickListener,
) {
    setOnClickListener(
        object : OnSafeClickListener(clickThreshold) {
            override fun onSafeClick(v: View) {
                listener.onClick(v)
            }
        },
    )
}

/**
 * Class that manages clicks and "throttles" the event so that no more than one event
 * can be fired in less than [CLICK_THRESHOLD_MS] intervals.
 *
 * The throttling is not regular, so events won't be fired exactly on [CLICK_THRESHOLD_MS]
 * intervals, instead they are fired the first time the click is received and the threshold
 * is passed.
 *
 */

class SafeClick {
    companion object {
        @VisibleForTesting
        const val CLICK_THRESHOLD_MS = 700L

        @VisibleForTesting
        var lastEmittedClickTimestamp = 0L

        @JvmStatic
        @JvmOverloads
        @Suppress("FORBIDDEN_SYNCHRONIZED_BY_VALUE_CLASSES_OR_PRIMITIVES")
        fun execute(
            clickThreshold: Long = CLICK_THRESHOLD_MS,
            lambda: () -> Unit,
        ) {
            synchronized(lastEmittedClickTimestamp) {
                System.currentTimeMillis().also {
                    if (it > lastEmittedClickTimestamp + clickThreshold || it < lastEmittedClickTimestamp) {
                        lastEmittedClickTimestamp = it
                        lambda()
                    }
                }
            }
        }
    }
}

/**
 * Click listener to be applied to a view that wishes to throttle clicks, so that two
 * clicks cannot be processed if the time between them is less than [CLICK_THRESHOLD_MS].
 */
@VisibleForTesting
abstract class OnSafeClickListener(private val clickThreshold: Long) : View.OnClickListener {
    /**
     * This click event warranties that the click won't be rapid-fired in less than
     * [CLICK_THRESHOLD_MS intervals].
     */
    abstract fun onSafeClick(v: View)

    /**
     * Events are captured in a regular onClick event and throttled through a safe
     * thread environment.
     **/
    override fun onClick(v: View) {
        SafeClick.execute(clickThreshold) {
            onSafeClick(v)
        }
    }
}
