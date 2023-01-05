package com.example.productivityapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.productivityapp.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    var REC = ArrayList<ProductivityBlocks>()
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ProductivityBlocksAdapter
    lateinit var recyclerView: RecyclerView
    val addDialog = Filldata()
    private lateinit var nBlockViewModel: BlockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        nBlockViewModel= ViewModelProvider(this).get(BlockViewModel::class.java)
        nBlockViewModel.readAllData.observe(this, androidx.lifecycle.Observer { BlockDB -> adapter.NewTask(BlockDB) })
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
        val Name = findViewById<EditText>(R.id.filld_name)
        val gname = Name.text.toString()
        val Desc = findViewById<EditText>(R.id.filld_description)
        val gdesc = Desc.text.toString()
        val DeadLine =  findViewById<EditText>(R.id.filld_Date)
        val gdate = DeadLine.text.toString()
        val Exp = true
        val Status = "Выполняется"
        val Type = "Движимый"
        if (gname.isEmpty() && gdesc.isEmpty()) {
            val hleb =Toast.makeText(this,"Заполните все поля", Toast.LENGTH_SHORT)
            hleb.show()
        } else {
            val task = ProductivityBlocks(
                gname, gdesc, gdate, Exp, Status, Type
            )
            nBlockViewModel.addBlock(task)
            /*REC.add(task)
            adapter.NewTask(REC)*/
            getSupportFragmentManager().beginTransaction()
                .remove(addDialog)
                .commit()
            val hleb =Toast.makeText(this,"Список обновлен", Toast.LENGTH_SHORT)
            hleb.show()
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
    




