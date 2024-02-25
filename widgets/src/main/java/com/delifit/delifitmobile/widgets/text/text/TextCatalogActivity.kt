/*
 * TextCatalogActivity.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.text

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delifit.delifitmobile.widgets.databinding.ActivityTextCatalogBinding

class TextCatalogActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityTextCatalogBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
