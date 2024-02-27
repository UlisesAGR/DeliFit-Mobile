package com.delifit.delifitmobile.utils

import android.view.View
import android.widget.Button
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import kotlin.concurrent.thread

@RunWith(MockitoJUnitRunner.StrictStubs::class)
class SetOnSafeClickListenerTest {
    private open class OnSafeClickListenerTester(val button: Button) :
        OnSafeClickListener(SafeClick.CLICK_THRESHOLD_MS) {
        override fun onSafeClick(v: View) {
            button.callOnClick()
        }
    }

    @Before
    fun resetTime() {
        SafeClick.lastEmittedClickTimestamp = 0L
    }

    @Test
    fun `Test One Rapid Click`() {
        val button = mock(Button::class.java)
        val listener = spy(OnSafeClickListenerTester(button))
        listener.onClick(button)
        verify(listener).onClick(button)
        verify(button).callOnClick()
    }

    @Test
    fun `Test Rapid Click`() {
        val button = mock(Button::class.java)
        val onSafeClickListener = OnSafeClickListenerTester(button)
        for (i in 0..10) {
            onSafeClickListener.onClick(button)
        }
        thread {
            Thread.sleep(50L)
            verify(button, times(1)).callOnClick()
        }
    }
}
