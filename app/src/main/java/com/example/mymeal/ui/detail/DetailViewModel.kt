package com.example.mymeal.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mymeal.data.MealRepository

class DetailViewModel(private val mealRepository: MealRepository) : ViewModel() {
    fun getDetail(id: String): LiveData<MealDetailEntity> =
        mealRepository.getDetailMeal(id)
}