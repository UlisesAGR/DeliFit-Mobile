package com.delifit.delifitmobile.core.domain

import com.delifit.delifitmobile.core.domain.model.toDomain
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipe
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipeResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductTest {
    @Test
    fun `recipe response to recipe Test`() = runBlocking {
        val expected = recipe
        val actual = recipeResponse.toDomain()
        assertEquals(expected, actual)
    }
}
