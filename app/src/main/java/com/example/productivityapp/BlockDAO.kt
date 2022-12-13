package com.example.productivityapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BlockDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addBlock(block: ProductivityBlocks)

    @Query("SELECT * FROM Block1 ORDER BY id ASC")
    fun readAllData(): LiveData<List<ProductivityBlocks>>

}