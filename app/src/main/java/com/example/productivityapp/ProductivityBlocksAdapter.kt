package com.example.productivityapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import org.w3c.dom.Text

class ProductivityBlocksAdapter: RecyclerView.Adapter<ProductivityBlocksAdapter.ProductivityBlocksHolder>() {
    var TList = emptyList<ProductivityBlocks>()
    class ProductivityBlocksHolder(view: View): RecyclerView.ViewHolder(view){
        val linearLayout : LinearLayout = view.findViewById(R.id.DateLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductivityBlocksHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productivityblockdesign,parent, false)
        return ProductivityBlocksHolder(view)
    }

    override fun onBindViewHolder(holder: ProductivityBlocksHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.BlockDate).text = TList[position].EndDate.toString()
        holder.itemView.findViewById<TextView>(R.id.BlockName).text = TList[position].Name
        holder.itemView.findViewById<TextView>(R.id.BlockInfo).text = TList[position].Description

        val isExpandable : Boolean = TList[position].Expandable
        holder.linearLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        holder.itemView.findViewById<TextView>(R.id.BlockName).setOnClickListener{

            TList[position].Expandable = !TList[position].Expandable
            notifyItemChanged(position)
        }


    }

    override fun getItemCount(): Int {
        return TList.size
    }

    fun NewTask(list: List<ProductivityBlocks>){
        TList = list
        notifyDataSetChanged()
    }
}