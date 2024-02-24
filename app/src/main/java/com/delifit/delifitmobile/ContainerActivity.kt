/*
 * ContainerActivity.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.delifit.delifitmobile.databinding.ActivityContainerBinding
import com.delifit.delifitmobile.utils.materialDialog
import com.delifit.delifitmobile.utils.onBackPressedHandler
import com.delifit.delifitmobile.utils.setupNavController

class ContainerActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityContainerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        splash.setKeepOnScreenCondition { false }
        setInitUi()
    }

    private fun setInitUi() {
        initNavigation()
        onBackPressedHandler()
    }

    private fun initNavigation() =
        with(binding) {
            containerBottomNavigationView.setupNavController(
                supportFragmentManager,
                containerFragmentContainerView.id,
            )
        }

    private fun onBackPressedHandler() {
        onBackPressedDispatcher.onBackPressedHandler(this) {
            materialDialog(
                title = getString(R.string.app_message),
                message = getString(R.string.app_are_you_sure_about_exiting_the_app),
                textNegativeButton = getString(R.string.app_cancel),
                textPositiveButton = getString(R.string.app_accept),
            ) {
                finish()
            }
        }
    }
}
