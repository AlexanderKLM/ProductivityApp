package com.example.productivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.productivityapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var  REC = ArrayList<ProductivityBlocks>()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductivityBlocksAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()

    }

    private fun initial(){
       recyclerView = binding.mainblockRV
        adapter = ProductivityBlocksAdapter()
        recyclerView.adapter = adapter
        binding.button111.setOnClickListener{
            val task = ProductivityBlocks("Задание", "Бла бла", "14:10")
            REC.add(task)
            adapter.NewTask(REC)
        }
    }

}