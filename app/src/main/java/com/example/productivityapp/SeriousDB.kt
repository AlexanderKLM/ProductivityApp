package com.example.productivityapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [SeriousBlocks::class], version = 1, exportSchema = false)
@TypeConverters(ConverterBlock::class)
abstract class SeriousDB: RoomDatabase() {
    abstract fun SeriousDAO(): SeriousDAO
    companion object {
        @Volatile
        private var INSTANCE: SeriousDB? = null

        fun getDB(context: Context): SeriousDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SeriousDB::class.java,
                    "Block2").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}