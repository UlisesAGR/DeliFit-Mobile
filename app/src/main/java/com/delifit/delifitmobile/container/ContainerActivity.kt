/*
 * ContainerActivity.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.container

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.delifit.delifitmobile.R
import com.delifit.delifitmobile.container.viewmodel.ContainerViewModel
import com.delifit.delifitmobile.databinding.ActivityContainerBinding
import com.delifit.delifitmobile.utils.collect
import com.delifit.delifitmobile.utils.materialDialog
import com.delifit.delifitmobile.utils.progressVisibility
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContainerActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityContainerBinding.inflate(layoutInflater)
    }

    private val containerViewModel: ContainerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        splash.setKeepOnScreenCondition { false }
        setInitUi()
    }

    private fun setInitUi() {
        containerViewModel.getRecipesUseCase()
        setFlows()
    }

    private fun setFlows() {
        collect(containerViewModel.containerState) { state ->
            showDialog(state.message)
            setViewVisibility(state.loading)
        }
    }

    private fun setViewVisibility(loading: Boolean) =
        with(binding) {
            progressLayout.progressVisibility(loading)
        }

    private fun showDialog(message: String) {
        materialDialog(
            title = getString(R.string.app_message),
            message,
            textNegativeButton = getString(R.string.app_cancel),
            textPositiveButton = getString(R.string.app_accept),
        )
    }
}
