/*
 * Progress.kt
 * Created by Ulises Gonzalez on 26/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.progres

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.delifit.delifitmobile.utils.AppLog
import com.delifit.delifitmobile.utils.show
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.ProgressBinding

class Progress @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ProgressBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.Progress).apply {
            try {
                setText(getString(R.styleable.Progress_textProgress))
            } catch (exception: Exception) {
                AppLog.log.exception(
                    tag = this,
                    exception,
                )
            } finally {
                recycle()
            }
        }
    }

    private fun setText(textLoading: String?) {
        with(binding.textLoading) {
            if (!textLoading.isNullOrEmpty()) {
                text = textLoading
                show()
            }
        }
    }
}
