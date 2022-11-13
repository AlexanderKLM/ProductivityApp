package com.example.productivityapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.productivityapp.databinding.ProductivityblockdesignBinding

class ProductivityBlocksAdapter: RecyclerView.Adapter<ProductivityBlocksAdapter.ProductivityBlocksHolder>() {

    class ProductivityBlocksHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ProductivityblockdesignBinding.bind(item)
        fun bind(Block: ProductivityBlocks) = with(binding){
            BlockName.setText(Block.Name)
            BlockDate.setText(Block.DeadLine)
            BlockInfo.setText(Block.Description)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductivityBlocksHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.productivityblockdesign,parent, false)
        return ProductivityBlocksHolder(view)
    }

    override fun onBindViewHolder(holder: ProductivityBlocksHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}