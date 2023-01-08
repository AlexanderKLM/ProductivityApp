package com.example.productivityapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [ProductivityBlocks::class], version = 1, exportSchema = false)
@TypeConverters(ConverterBlock::class)
abstract class BlockDB: RoomDatabase() {
    abstract fun BlockDAO(): BlockDAO
    companion object {
        @Volatile
        private var INSTANCE: BlockDB? = null

        fun getDB(context: Context): BlockDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BlockDB::class.java,
                     "Block1").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}