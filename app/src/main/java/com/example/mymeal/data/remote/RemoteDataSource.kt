package com.example.mymeal.data.remote

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

    fun getSeafoodCategory(callback : LoadSeafoodCallback){
        val list = ArrayList<Meals>()
        var client = ApiConfig.getApiService().getMeals(category)
        client.enqueue(object : Callback<MealsResponse>{
            override fun onResponse(call: Call<MealsResponse>, response: Response<MealsResponse>) {
                if(response.isSuccessful){
                    response.body()?.meals?.let { list.addAll(it) }

                    callback.onAllSeafoodReceived(list)
                }
            }

            override fun onFailure(call: Call<MealsResponse>, t: Throwable) {
                callback.onErrorResponse(t.message.toString())
            }

        })
    }


    interface  LoadSeafoodCallback{
        fun onAllSeafoodReceived(mealsResponse: ArrayList<Meals>)
        fun onErrorResponse(error : String)
    }
}