package com.example.customlayoutmanager

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.customlayoutmanager.databinding.ItemLayoutBinding

class MyAdapter(private val listOfCategories: List<Category>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bind(category: Category) {
            val marginLayoutParams = (binding.layout.layoutParams as ViewGroup.MarginLayoutParams)

            // SET RANDOM MARGINS
            marginLayoutParams.setMargins(
                (25..150).random(),
                (25..150).random(),
                (25..50).random(),
                (0..50).random()
            )
            binding.layout.layoutParams = marginLayoutParams

            val scale = itemView.context.resources.displayMetrics.density

            // RANDOM SIDES
            val side = ((120 .. 150).random() * scale + 0.5f).toInt()
            binding.cardView.radius = (side / 2f)

            // SET RANDOM SIDES
            binding.image.layoutParams.apply {
                width = side
                height = side
            }

            binding.image.setImageResource(category.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listOfCategories[position])
    }

    override fun getItemCount(): Int = listOfCategories.size
}