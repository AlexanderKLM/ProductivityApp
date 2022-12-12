package com.example.productivityapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.productivityapp.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

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



        val itemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: ViewHolder,
                target: ViewHolder
            ): Boolean {
                val pos = viewHolder.adapterPosition
                val final = target.adapterPosition
                Collections.swap(adapter.TList,pos, final)
                adapter.notifyItemMoved(pos,final)
                return false
            }

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                TODO("Not yet implemented")
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun initial(){
       recyclerView = binding.mainblockRV
        adapter = ProductivityBlocksAdapter()
        recyclerView.adapter = adapter
        binding.button111.setOnClickListener{
            val task = ProductivityBlocks("Задание", "Мороз и солнце день чудесный, чего ты дремлешь друг прелестный", "14:10")
            REC.add(task)
            adapter.NewTask(REC)
        }
    }

}