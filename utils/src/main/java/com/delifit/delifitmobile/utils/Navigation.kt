/*
 * Navigation.kt
 * Created by Ulises Gonzalez on 23/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.utils

import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * This extension show material dialog
 */
fun BottomNavigationView.setupNavController(
    supportFragmentManager: FragmentManager,
    fragmentContainerViewId: Int,
) {
    this.setupWithNavController(
        (supportFragmentManager.findFragmentById(fragmentContainerViewId) as NavHostFragment).navController,
    )
}
