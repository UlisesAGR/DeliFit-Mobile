/*
 * EmptyStateList.kt
 * Created by Ulises Gonzalez on 27/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.emptystates

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.delifit.delifitmobile.utils.AppLog
import com.delifit.delifitmobile.utils.Constants.ANIMATION_ALFA_HIDDEN
import com.delifit.delifitmobile.utils.Constants.ANIMATION_ALFA_VISIBLE
import com.delifit.delifitmobile.utils.show
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.EmptyStateListBinding

class EmptyState @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        EmptyStateListBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.EmptyState).apply {
            try {
                showEmptyState()
                setImage(getResourceId(R.styleable.EmptyState_imageEmptyStateList, 0))
                setDescription(getString(R.styleable.EmptyState_descriptionEmptyStateList))
                setTitle(getString(R.styleable.EmptyState_titleEmptyStateList))
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

    private fun setImage(image: Int) {
        with(binding.emptyStateImageView) {
            if (image != 0) {
                setImageResource(image)
                show()
            }
        }
    }

    private fun setTitle(title: String?) {
        with(binding.titleTextView) {
            if (!title.isNullOrEmpty()) {
                text = title
                show()
            }
        }
    }

    private fun setDescription(description: String?) {
        with(binding.descriptionTextView) {
            if (!description.isNullOrEmpty()) {
                text = description
                show()
            }
        }
    }

    private fun showEmptyState() {
        clearAnimation()
        animIn()
    }

    private fun animIn() {
        with(binding.emptyStateRoot) {
            alpha = ANIMATION_ALFA_HIDDEN
            show()
            animate()
                .alpha(ANIMATION_ALFA_VISIBLE)
                .setDuration(resources.getInteger(android.R.integer.config_mediumAnimTime).toLong())
                .setListener(null)
        }
    }
}
