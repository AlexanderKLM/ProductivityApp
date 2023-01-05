package com.example.productivityapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Block1")

data class ProductivityBlocks(val Name: String, val Description: String, val DeadLine: String, var Expandable: Boolean = false, val Status: String, val Type: String) {
@PrimaryKey(autoGenerate = true)
var id: Int = 0
}