package com.example.mymeal.di

import com.example.mymeal.data.MealRepository
import com.example.mymeal.data.remote.RemoteDataSource

object Injection {
    fun provideRepository(): MealRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return MealRepository.getInstance(remoteDataSource)
    }
}