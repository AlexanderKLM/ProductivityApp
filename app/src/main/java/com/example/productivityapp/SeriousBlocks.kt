package com.example.productivityapp

import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Block2")

data class SeriousBlocks(
    val Name: String, val Description: String?, val TimeReq: Int, var Expandable: Boolean = false,
    val Status: String, val Type: String, val priority: Int, val CreationDate: String, val EndDate: String, val TaskStart: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}