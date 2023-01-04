package com.example.productivityapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Color.DKGRAY
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.TOUCH_SLOP_DEFAULT
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.productivityapp.databinding.ActivityMainBinding
import java.util.*
import kotlin.reflect.typeOf


class MainActivity : AppCompatActivity() {
    var REC = ArrayList<ProductivityBlocks>()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductivityBlocksAdapter
    lateinit var recyclerView: RecyclerView
    val addDialog = Filldata()


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
                replace(R.id.F_layout, addDialog)
                commit()
            }
            val b = binding.button111
            b.isClickable = false
            b.setBackgroundColor(Color.parseColor("#9F9F9F"))

        }
    }

    fun new_block(view: View) {
        var Name = findViewById<EditText>(R.id.filld_name)
        var gname = Name.text.toString()
        var Desc = findViewById<EditText>(R.id.filld_description)
        var gdesc = Desc.text.toString()
        val DeadLine = "29 May"
        val Exp = true
        val Status = "Выполняется"
        val Type = "Движимый"
        if (gname.isEmpty() &&  gdesc.isEmpty()) {
            val hleb =Toast.makeText(this,"Заполните все поля", Toast.LENGTH_SHORT)
            hleb.show()
        } else {
            val task = ProductivityBlocks(
                gname, gdesc, DeadLine, Exp, Status, Type
            )
            REC.add(task)
            adapter.NewTask(REC)
            getSupportFragmentManager().beginTransaction()
                .remove(addDialog)
                .commit()
            val b = binding.button111
            b.isClickable = true
            b.backgroundTintList = getColorStateList(R.color.purple_500)
              }
    }

    fun fragment_back(view: View) {
            getSupportFragmentManager().beginTransaction()
                .remove(addDialog)
                .commit()
        val b = binding.button111
        b.isClickable = true
        b.backgroundTintList = getColorStateList(R.color.purple_500)
    }
}
    




