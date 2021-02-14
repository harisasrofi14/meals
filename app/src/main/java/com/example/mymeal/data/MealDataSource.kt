package com.example.mymeal.data

import androidx.lifecycle.LiveData
import com.example.mymeal.data.remote.response.Meals
import com.example.mymeal.ui.detail.MealDetailEntity
import com.example.mymeal.ui.main.MealEntity

interface MealDataSource {

    fun getMeals(): LiveData<List<MealEntity>>
    fun getDetailMeal(id: String): LiveData<MealDetailEntity>
}