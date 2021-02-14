package com.example.mymeal.data.remote

import com.example.mymeal.data.remote.response.MealDetail
import com.example.mymeal.data.remote.response.MealDetailResponse
import com.example.mymeal.data.remote.response.Meals
import com.example.mymeal.data.remote.response.MealsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        const val category = "Seafood"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMeals(callback: LoadMealsCallback) {
        val list = ArrayList<Meals>()
        val client = ApiConfig.getApiService().getMeals(category)
        client.enqueue(object : Callback<MealsResponse> {
            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                if (response.isSuccessful) {
                    response.body()?.meals?.let { list.addAll(it) }

                    callback.onAllMealReceived(list)
                }
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                callback.onErrorResponse(t.message.toString())
            }

        })
    }

    fun getDetail(callback: LoadDetailMealCallback, id: String) {
        var detailMeal = MealDetail()
        val client = ApiConfig.getApiService().getDetail(id)
        client.enqueue(object : Callback<MealDetailResponse> {
            override fun onResponse(
                call: Call<MealDetailResponse>,
                response: Response<MealDetailResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.meals?.get(0).let {
                        if (it != null) {
                            detailMeal =it
                        }
                    }
                }
                callback.onDetailMealReceived(detailMeal)
            }

            override fun onFailure(call: Call<MealDetailResponse>, t: Throwable) {
                callback.onErrorResponse(t.message.toString())
            }

        })
    }


    interface LoadMealsCallback {
        fun onAllMealReceived(mealsResponse: ArrayList<Meals>)
        fun onErrorResponse(error: String)
    }

    interface LoadDetailMealCallback {
        fun onDetailMealReceived(detailResponse: MealDetail)
        fun onErrorResponse(error: String)
    }
}