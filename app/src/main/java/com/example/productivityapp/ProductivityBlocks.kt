package com.example.productivityapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Time

@Entity(tableName = "Block1")

data class ProductivityBlocks(val Name: String, val Description: String?, val TimeReq: Int, var Expandable: Boolean = false, val Status: String, val Type: String, val priority: Int, val CreationDate: Date, val EndDate: Date, val TaskStart: Date ) {
@PrimaryKey(autoGenerate = true)
var id: Int = 0
}

