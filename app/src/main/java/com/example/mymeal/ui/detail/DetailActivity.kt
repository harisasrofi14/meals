package com.example.mymeal.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mymeal.R
import com.example.mymeal.ui.main.MealEntity
import com.example.mymeal.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity() {
    private val ingredientAdapter = IngredientAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mealId = intent.getStringExtra("mealId")
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        rv_ingredient.layoutManager = LinearLayoutManager(this)
        rv_ingredient.adapter = ingredientAdapter
        progress_bar.visibility = View.VISIBLE

        mealId?.let {
            viewModel.getDetail(it).observe(this, Observer { detail ->
                initView(detail)
                processIngredient(detail)
                tv_title_ingredient.visibility = View.VISIBLE
                tv_title_instructions.visibility = View.VISIBLE
                progress_bar.visibility = View.GONE
            })
        }
    }

    private fun initView(detailEntity: MealDetailEntity) {
        Glide.with(this)
            .load(detailEntity.strMealThumb)
            .centerCrop()
            .into(iv_detail_thumbnail)
        tv_detail_title.text = detailEntity.strMeal
        tv_description.text = detailEntity.strInstructions
    }

    private fun processIngredient(detailEntity: MealDetailEntity) {
        val mealsList = ArrayList<IngredientEntity>()

        when {
            !detailEntity.strIngredient1.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient1,
                    detailEntity.strMeasure1
                )
            )
        }
        when {
            !detailEntity.strIngredient2.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient2,
                    detailEntity.strMeasure2
                )
            )
        }
        when {
            !detailEntity.strIngredient3.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient3,
                    detailEntity.strMeasure3
                )
            )
        }
        when {
            !detailEntity.strIngredient4.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient4,
                    detailEntity.strMeasure4
                )
            )
        }
        when {
            !detailEntity.strIngredient5.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient5,
                    detailEntity.strMeasure5
                )
            )
        }
        when {
            !detailEntity.strIngredient6.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient6,
                    detailEntity.strMeasure6
                )
            )
        }
        when {
            !detailEntity.strIngredient7.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient7,
                    detailEntity.strMeasure7
                )
            )
        }
        when {
            !detailEntity.strIngredient8.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient8,
                    detailEntity.strMeasure8
                )
            )
        }
        when {
            !detailEntity.strIngredient9.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient9,
                    detailEntity.strMeasure9
                )
            )
        }
        when {
            !detailEntity.strIngredient10.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient10,
                    detailEntity.strMeasure10
                )
            )
        }
        when {
            !detailEntity.strIngredient11.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient11,
                    detailEntity.strMeasure11
                )
            )
        }
        when {
            !detailEntity.strIngredient12.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient12,
                    detailEntity.strMeasure12
                )
            )
        }
        when {
            !detailEntity.strIngredient13.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient13,
                    detailEntity.strMeasure13
                )
            )
        }
        when {
            !detailEntity.strIngredient14.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient14,
                    detailEntity.strMeasure14
                )
            )
        }
        when {
            !detailEntity.strIngredient15.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient15,
                    detailEntity.strMeasure15
                )
            )
        }
        when {
            !detailEntity.strIngredient16.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient16,
                    detailEntity.strMeasure16
                )
            )
        }
        when {
            !detailEntity.strIngredient17.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient17,
                    detailEntity.strMeasure17
                )
            )
        }
        when {
            !detailEntity.strIngredient18.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient18,
                    detailEntity.strMeasure18
                )
            )
        }
        when {
            !detailEntity.strIngredient19.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient19,
                    detailEntity.strMeasure19
                )
            )
        }
        when {
            !detailEntity.strIngredient20.isNullOrEmpty() -> mealsList.add(
                IngredientEntity(
                    detailEntity.strIngredient20,
                    detailEntity.strMeasure20
                )
            )
        }

        ingredientAdapter.setData(mealsList)


    }
}