package com.example.mymeal.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymeal.R
import kotlinx.android.synthetic.main.item_meal.view.*

class MealAdapter : RecyclerView.Adapter<MealAdapter.ViewHolder>() {
    private var mData = ArrayList<MealEntity>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    fun setData(item: List<MealEntity>) {
        mData = item as ArrayList<MealEntity>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MealAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_meal, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealAdapter.ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(meal: MealEntity) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(meal.strMealThumb)
                    .override(250, 250)
                    .into(iv_thumbnail)
                tv_title.text = meal.strMeal
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(meal)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MealEntity)
    }
}