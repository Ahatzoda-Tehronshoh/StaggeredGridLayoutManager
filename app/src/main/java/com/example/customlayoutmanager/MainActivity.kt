package com.example.customlayoutmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.customlayoutmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfCategories = mutableListOf<Category>()
        val listOfImages = listOf(
            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.forth,
            R.drawable.fifth,
            R.drawable.sixth,
            R.drawable.seventh
        )

        for (i in 1..100)
            listOfCategories.add(
                Category(i, "My $i Category", listOfImages[(0..6).random()])
            )


        val myAdapter = MyAdapter(listOfCategories)

        binding.recyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(
                3,
                RecyclerView.HORIZONTAL
            )

            adapter = myAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}