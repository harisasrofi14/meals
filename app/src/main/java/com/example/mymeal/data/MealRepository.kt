package com.example.mymeal.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymeal.data.remote.RemoteDataSource
import com.example.mymeal.data.remote.response.MealDetail
import com.example.mymeal.data.remote.response.Meals
import com.example.mymeal.ui.detail.MealDetailEntity
import com.example.mymeal.ui.main.MealEntity

class MealRepository private constructor(private val remoteDataSource: RemoteDataSource) :
        MealDataSource {

    companion object {
        @Volatile
        private var instance: MealRepository? = null
        fun getInstance(remoteDataSource: RemoteDataSource): MealRepository =
                instance ?: synchronized(this) {
                    instance ?: MealRepository(remoteDataSource)
                }
    }

    override fun getMeals(): LiveData<List<MealEntity>> {
        val mealsResult = MutableLiveData<List<MealEntity>>()

        remoteDataSource.getMeals(object : RemoteDataSource.LoadMealsCallback {
            override fun onAllMealReceived(mealsResponse: ArrayList<Meals>) {
                val mealsList = ArrayList<MealEntity>()

                for (data in mealsResponse) {
                    val meals = MealEntity(
                            data.strMeal,
                            data.strMealThumb,
                            data.idMeal
                    )
                    mealsList.add(meals)
                }
                mealsResult.postValue(mealsList)
            }

            override fun onErrorResponse(error: String) {
                Log.e("getMeals", error)
            }

        })
        return mealsResult
    }

    override fun getDetailMeal(id: String): LiveData<MealDetailEntity> {
        val detailMealResult = MutableLiveData<MealDetailEntity>()
        remoteDataSource.getDetail(object : RemoteDataSource.LoadDetailMealCallback {
//            override fun onDetailMealReceived(detailResponse: MealDetailResponse) {
//                val detail = MealDetailEntity(
//                    detailResponse.meals?.get(0)?.strMeal,
//                    detailResponse.meals?.strMealThumb,
//                    detailResponse.meals?.idMeal,
//                    detailResponse.meals?.strDrinkAlternate,
//                    detailResponse.meals?.strCategory,
//                    detailResponse.meals?.strArea,
//                    detailResponse.meals?.strInstructions,
//                    detailResponse.meals?.strTags,
//                    detailResponse.meals?.strYoutube,
//                    detailResponse.meals?.strIngredient1,
//                    detailResponse.meals?.strIngredient2,
//                    detailResponse.meals?.strIngredient3,
//                    detailResponse.meals?.strIngredient4,
//                    detailResponse.meals?.strIngredient5,
//                    detailResponse.meals?.strIngredient6,
//                    detailResponse.meals?.strIngredient7,
//                    detailResponse.meals?.strIngredient8,
//                    detailResponse.meals?.strIngredient9,
//                    detailResponse.meals?.strIngredient10,
//                    detailResponse.meals?.strIngredient11,
//                    detailResponse.meals?.strIngredient12,
//                    detailResponse.meals?.strIngredient13,
//                    detailResponse.meals?.strIngredient14,
//                    detailResponse.meals?.strIngredient15,
//                    detailResponse.meals?.strIngredient16,
//                    detailResponse.meals?.strIngredient17,
//                    detailResponse.meals?.strIngredient18,
//                    detailResponse.meals?.strIngredient19,
//                    detailResponse.meals?.strIngredient20,
//                )
//                detailMealResult.postValue(detail)
//            }

            override fun onDetailMealReceived(detailResponse: MealDetail) {
                val detail = MealDetailEntity(
                        detailResponse.strMeal,
                        detailResponse.strMealThumb,
                        detailResponse.idMeal,
                        detailResponse.strDrinkAlternate,
                        detailResponse.strCategory,
                        detailResponse.strArea,
                        detailResponse.strInstructions,
                        detailResponse.strTags,
                        detailResponse.strYoutube,
                        detailResponse.strIngredient1,
                        detailResponse.strIngredient2,
                        detailResponse.strIngredient3,
                        detailResponse.strIngredient4,
                        detailResponse.strIngredient5,
                        detailResponse.strIngredient6,
                        detailResponse.strIngredient7,
                        detailResponse.strIngredient8,
                        detailResponse.strIngredient9,
                        detailResponse.strIngredient10,
                        detailResponse.strIngredient11,
                        detailResponse.strIngredient12,
                        detailResponse.strIngredient13,
                        detailResponse.strIngredient14,
                        detailResponse.strIngredient15,
                        detailResponse.strIngredient16,
                        detailResponse.strIngredient17,
                        detailResponse.strIngredient18,
                        detailResponse.strIngredient19,
                        detailResponse.strIngredient20,
                        detailResponse.strMeasure1,
                        detailResponse.strMeasure2,
                        detailResponse.strMeasure3,
                        detailResponse.strMeasure4,
                        detailResponse.strMeasure5,
                        detailResponse.strMeasure6,
                        detailResponse.strMeasure7,
                        detailResponse.strMeasure8,
                        detailResponse.strMeasure9,
                        detailResponse.strMeasure10,
                        detailResponse.strMeasure11,
                        detailResponse.strMeasure12,
                        detailResponse.strMeasure13,
                        detailResponse.strMeasure14,
                        detailResponse.strMeasure15,
                        detailResponse.strMeasure16,
                        detailResponse.strMeasure17,
                        detailResponse.strMeasure18,
                        detailResponse.strMeasure19,
                        detailResponse.strMeasure20,
                )
                detailMealResult.postValue(detail)
            }

            override fun onErrorResponse(error: String) {
                Log.e("getDetailMeal", error)
            }

        }, id)
        return detailMealResult
    }


}