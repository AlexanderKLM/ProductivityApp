package com.example.productivityapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.databinding.ProductivityblockdesignBinding

class ProductivityBlocksAdapter: RecyclerView.Adapter<ProductivityBlocksAdapter.ProductivityBlocksHolder>() {
    var TList = ArrayList<ProductivityBlocks>()
    class ProductivityBlocksHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductivityBlocksHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productivityblockdesign,parent, false)
        return ProductivityBlocksHolder(view)
    }

    override fun onBindViewHolder(holder: ProductivityBlocksHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.BlockDate).text = TList[position].DeadLine
        holder.itemView.findViewById<TextView>(R.id.BlockName).text = TList[position].Name
        holder.itemView.findViewById<TextView>(R.id.BlockInfo).text = TList[position].Description
    }

    override fun getItemCount(): Int {
        return TList.size
    }

    fun NewTask(list: ArrayList<ProductivityBlocks>){
        TList = list
        notifyDataSetChanged()
    }
}