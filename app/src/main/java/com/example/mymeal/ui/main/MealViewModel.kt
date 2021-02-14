package com.example.mymeal.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mymeal.data.MealRepository

class MealViewModel(private val mealRepository: MealRepository) : ViewModel() {
    fun getMeals(): LiveData<List<MealEntity>> = mealRepository.getMeals()
}