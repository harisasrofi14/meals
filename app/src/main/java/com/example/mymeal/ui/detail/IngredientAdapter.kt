package com.example.mymeal.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymeal.R
import kotlinx.android.synthetic.main.item_ingredient.view.*


class IngredientAdapter : RecyclerView.Adapter<IngredientAdapter.ViewHolder>() {
    private var mData = ArrayList<IngredientEntity>()

    fun setData(item: List<IngredientEntity>) {
        mData = item as ArrayList<IngredientEntity>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
            viewGroup: ViewGroup,
            viewType: Int
    ): IngredientAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_ingredient, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientAdapter.ViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ingredient: IngredientEntity) {
            with(itemView) {
                tv_ingredient.text = ingredient.strIngredient
                tv_amount.text = ingredient.strMeasure
            }
        }
    }

}