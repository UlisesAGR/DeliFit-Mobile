package com.delifit.delifitmobile.core.di

import kotlinx.coroutines.Dispatchers
import org.junit.Assert
import org.junit.Test

class DispatchersModuleTest {
    @Test
    fun testIoDispatcher() {
        val expected = Dispatchers.IO
        //Given
        val dispatchersModule = DispatchersModule
        //When
        val ioDispatcher = dispatchersModule.provideIoDispatcher()
        //Then
        Assert.assertEquals(ioDispatcher, expected)
    }
}