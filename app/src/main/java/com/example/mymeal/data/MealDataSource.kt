package com.example.mymeal.data

import androidx.lifecycle.LiveData
import com.example.mymeal.data.remote.response.Meals

interface MealDataSource {
    fun getSeafoodCategory() : LiveData<List<Meals>>
}