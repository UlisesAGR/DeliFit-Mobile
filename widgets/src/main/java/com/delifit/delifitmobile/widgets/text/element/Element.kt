/*
 * Element.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.element

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.delifit.delifitmobile.utils.AppLog
import com.delifit.delifitmobile.utils.LevelCooking
import com.delifit.delifitmobile.utils.show
import com.delifit.delifitmobile.utils.toLevelCooking
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.CardElementBinding

class Element @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        CardElementBinding.inflate(LayoutInflater.from(context), this, true)
    }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.Element).apply {
            try {
                setImage(getResourceId(R.styleable.Element_imageCardElement, 0))
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
        with(binding.logoImageView) {
            if (image != 0) {
                setImageResource(image)
                show()
            }
        }
    }

    fun setLevel(level: String) = with(binding) {
        when (level.toLevelCooking()) {
            LevelCooking.EASY -> textTextView.text =
                context.getString(R.string.widgets_easy)

            LevelCooking.NORMAL -> textTextView.text =
                context.getString(R.string.widgets_normal)

            LevelCooking.HARD -> textTextView.text =
                context.getString(R.string.widgets_hard)
        }
    }

    fun setText(text: String) {
        binding.textTextView.text = text
    }
}
