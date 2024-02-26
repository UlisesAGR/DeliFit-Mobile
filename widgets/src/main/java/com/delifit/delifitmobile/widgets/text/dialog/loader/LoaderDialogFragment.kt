/*
 * LoaderDialogFragment.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.widgets.text.dialog.loader

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.delifit.delifitmobile.utils.show
import com.delifit.delifitmobile.widgets.R
import com.delifit.delifitmobile.widgets.databinding.FragmentLoaderDialogBinding

class LoaderDialogFragment : DialogFragment() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FragmentLoaderDialogBinding.inflate(layoutInflater)
    }

    private lateinit var loaderDialogConfig: LoaderDialogConfig

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenLoaderDialog)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        setInitUi()
    }

    private fun setInitUi() {
        setTitle()
    }

    private fun setTitle() {
        loaderDialogConfig.apply {
            if (title.isNotEmpty()) {
                binding.titleTextView.apply {
                    text = title
                    show()
                }
            }
        }
    }

    companion object {
        const val TAG = "LoaderDialogFragment"

        fun newInstance(loaderDialogConfig: LoaderDialogConfig): LoaderDialogFragment =
            LoaderDialogFragment().apply {
                this.loaderDialogConfig = loaderDialogConfig
            }
    }
}
