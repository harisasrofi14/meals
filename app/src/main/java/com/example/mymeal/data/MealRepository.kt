package com.example.mymeal.data

import androidx.lifecycle.LiveData
import com.example.mymeal.data.remote.response.Meals

class MealRepository private  constructor(private  val remoteDataSource: MealDataSource):
MealDataSource{

    companion object{
        @Volatile
        private var instance : MealRepository? = null
        fun getInstance(remoteDataSource: MealDataSource):MealRepository =
            instance ?: synchronized(this){
               instance ?: MealRepository(remoteDataSource)
            }
    }


    override fun getSeafoodCategory(): LiveData<List<Meals>> {
        TODO("Not yet implemented")
    }
}