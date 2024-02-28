package com.delifit.delifitmobile.core.domain

import com.delifit.delifitmobile.core.domain.model.toDomain
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipe
import com.delifit.delifitmobile.core.utils.mock.RecipeMock.recipeResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ProductTest {
    @Test
    fun `Validate Transformation Of RecipeResponse To Recipe`() = runBlocking {
        val expected = recipe
        val actual = recipeResponse.toDomain()
        Assert.assertEquals(expected, actual)
    }
}
