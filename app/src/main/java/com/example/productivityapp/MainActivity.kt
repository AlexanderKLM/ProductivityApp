package com.example.productivityapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.productivityapp.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductivityBlocksAdapter
    lateinit var recyclerView: RecyclerView
    val filld = Filldata()
    val setTime = TimeCheck()
    val setBusy = Step2BusyJob()
    private lateinit var nBlockViewModel: BlockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nBlockViewModel = ViewModelProvider(this).get(BlockViewModel::class.java)
        nBlockViewModel.readAllData.observe(
            this,
            androidx.lifecycle.Observer { BlockDB -> adapter.NewTask(BlockDB) })
        initial()

        val setclock = findViewById<Button>(R.id.StartTaskstep1)
        val itemTouchHelper = ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: ViewHolder,
                target: ViewHolder
            ): Boolean {
                val pos = viewHolder.adapterPosition
                val final = target.adapterPosition
                Collections.swap(adapter.TList, pos, final)
                adapter.notifyItemMoved(pos, final)
                return false
            }

            override fun onSwiped(viewHolder: ViewHolder, direction: Int) {
                TODO("Not yet implemented")
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun initial() {
        recyclerView = binding.mainblockRV
        adapter = ProductivityBlocksAdapter()
        recyclerView.adapter = adapter
        binding.button111.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.F_layout, setTime)
                commit()
            }
            val b = binding.button111
            b.isVisible = false


        }
    }

    fun new_block(view: View) {
        val Name = findViewById<EditText>(R.id.S3Remind)
        val gname = Name.text.toString()
        val Desc = findViewById<EditText>(R.id.S3Desc)

    }

    fun fragment_back(view: View) {
        supportFragmentManager.beginTransaction().apply {
            remove(setTime)
            commit()
            binding.button111.isVisible = true

        }


    }

    fun S1Next(view: View) {
        supportFragmentManager.beginTransaction().apply {
            remove(setTime)
            replace(R.id.F_layout, setBusy)
            commit()
        }
    }

    fun S2Back(view: View) {
        supportFragmentManager.beginTransaction().apply {
            remove(setBusy)
            replace(R.id.F_layout, setTime)
            commit()
        }
    }
    fun S2Next(view: View) {
        supportFragmentManager.beginTransaction().apply {
            remove(setBusy)
            replace(R.id.F_layout, filld)
            commit()
        }
    }

    fun S3Back(view: View) {
        supportFragmentManager.beginTransaction().apply {
            remove(filld)
            replace(R.id.F_layout, setBusy)
            commit()
        }
    }


}
    




