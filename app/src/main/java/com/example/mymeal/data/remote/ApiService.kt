package com.example.mymeal.data.remote

import com.example.mymeal.data.remote.response.MealDetailResponse
import com.example.mymeal.data.remote.response.MealsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    //https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood
    @GET("filter.php")
    fun getMeals(
        @Query("c") c: String,
    ): Call<MealsResponse>

    @GET("lookup.php")
    fun getDetail(
        @Query("i") i: String,
    ): Call<MealDetailResponse>

}