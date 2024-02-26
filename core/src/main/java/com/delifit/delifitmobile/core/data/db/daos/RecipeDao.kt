/*
 * RecipesDao.kt
 * Created by Ulises Gonzalez on 25/02/24
 * Copyright (c) 2023. All rights reserved.
 */
package com.delifit.delifitmobile.core.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.delifit.delifitmobile.core.data.db.entities.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipesDao {
    @Transaction
    fun clearAndSaveRecipes(recipeList: List<RecipeEntity>) {
        clearDadBase()
        saveRecipes(recipeList)
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRecipes(recipeList: List<RecipeEntity>)

    @Query("SELECT * FROM recipe_table")
    fun readRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe_table WHERE id=:recipeId")
    fun readRecipeById(recipeId: Int): RecipeEntity

    @Query("DELETE FROM recipe_table")
    fun clearDadBase()
}
