/*
 * ButtonCatalogActivity.kt
 * Created by Ulises Gonzalez on 24/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delifit.delifitmobile.widgets.databinding.ActivityButtonCatalogBinding

class ButtonCatalogActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityButtonCatalogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
