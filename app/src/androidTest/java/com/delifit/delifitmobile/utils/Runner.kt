package com.delifit.delifitmobile.utils

import android.app.Application
import android.app.Instrumentation
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

class Runner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader,
        className: String,
        context: Context,
    ): Application = Instrumentation.newApplication(HiltTestApplication::class.java, context)
}
