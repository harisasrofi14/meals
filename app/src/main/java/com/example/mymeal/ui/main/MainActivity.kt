package com.example.mymeal.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mymeal.R
import com.example.mymeal.ui.detail.DetailActivity
import com.example.mymeal.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mealAdapter = MealAdapter()
        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[MealViewModel::class.java]
        progress_circular.visibility = View.VISIBLE
        viewModel.getMeals().observe(this, Observer { meals ->
            mealAdapter.setData(meals)
            progress_circular.visibility = View.GONE
        })
        with(rv_meals) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mealAdapter
        }
        mealAdapter.setOnItemClickCallback(object : MealAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MealEntity) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("mealId", data.idMeal)
                }
                startActivity(intent)
            }

        })
    }
}