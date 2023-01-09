package com.example.productivityapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SeriousDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSerious(blockS: SeriousBlocks)

    @Query("SELECT * FROM Block2")
    fun readAllDataser(): LiveData<List<SeriousBlocks>>



}