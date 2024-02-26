/*
 * LoaderDialogConfig.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.dialog.loader

import androidx.fragment.app.FragmentManager

class LoaderDialogConfig(
    val title: String = "",
) {
    private val loaderDialog: LoaderDialogFragment by lazy {
        LoaderDialogFragment.newInstance(this)
    }

    fun showLoaderDialog(fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction()
            .add(loaderDialog, LoaderDialogFragment.TAG)
            .commitAllowingStateLoss()
    }

    fun dismissLoaderDialog() {
        loaderDialog.dismiss()
    }

    fun setCancelable(isCancelable: Boolean) {
        loaderDialog.isCancelable = isCancelable
    }
}
