/*
 * EditTextGetting.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

/**
 * Reset errors from TextInputLayout
 */
fun TextInputLayout.resetError() {
    this.error = null
}

/**
 * Reset errors from TextInputLayout with clear focus
 */
fun TextInputLayout.resetErrorClearFocus() {
    this.error = null
    clearFocus()
}

/**
 * This method gets the string of an TextView
 */
fun TextView.getString(): String = this.text.toString()

/**
 * This method gets the string from an TextView
 * and transforms it to an integer
 */
fun TextView.getInt(): Int = this.text.toString().toInt()

/**
 * This method gets the string of an EditText
 */
fun EditText.getString(): String = this.text.toString()

/**
 * This method gets the string from an EditText
 * and transforms it to an integer
 */
fun EditText.getInt(): Int = this.text.toString().toInt()

/**
 * This method gets the string from an TextView
 * and transforms it to an Double
 */
fun TextView.getDouble(): Double = this.text.toString().toDouble()

/**
 * Set text watcher
 */
fun EditText.onTetWatcher(callback: (String) -> Unit) {
    this.addTextChangedListener(
        object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int,
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int,
            ) {
                callback(s.toString())
            }
        },
    )
}
