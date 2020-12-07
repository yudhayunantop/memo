package com.example.memo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope

// Annotates class to be a room database with a table (entity) of the Word class
@Database(entities = arrayOf(Memo::class), version = 1, exportSchema = false)
public abstract class MemoRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): MemoDao

    //menambahkan database pada instance program
    companion object{ //singleton prevents multiple instance of database opening at the same time

        @Volatile
        private var INSTANCE: MemoRoomDatabase? = null

        fun getDatabase(context: Context, viewModelScope: CoroutineScope): MemoRoomDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MemoRoomDatabase::class.java,
                    "memo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}