package com.delifit.delifitmobile.core.di

import okhttp3.OkHttpClient
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

class NetworkModuleTest {
    @Test
    fun testNetworkModule() {
        //Given
        val mockOkHttpClient = mock(OkHttpClient::class.java)
        //When
        val actual = NetworkModule
        //Then
        Assert.assertNotNull(actual.provideOkHttpClient())
        Assert.assertNotNull(actual.provideRetrofit(mockOkHttpClient))
    }
}