package com.delifit.delifitmobile.core.domain

import com.delifit.delifitmobile.core.domain.model.toDomain
import com.delifit.delifitmobile.core.utils.mock.StepsMock.steps
import com.delifit.delifitmobile.core.utils.mock.StepsMock.stepsResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StepsTest {
    @Test
    fun `Validate Transformation Of StepsResponse To Steps`() = runBlocking {
        //Given
        val expected = steps
        //When
        val actual = stepsResponse.toDomain()
        //Then
        Assert.assertEquals(expected, actual)
    }
}
