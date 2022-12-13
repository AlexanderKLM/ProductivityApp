package com.example.productivityapp

import androidx.room.Entity

@Entity(tableName = "Block1")
data class ProductivityBlocks (val ID: Int, val Name: String, val Description: String, val DeadLine: String, var Expandable: Boolean = false, val Status: String, val Type: String) {


}