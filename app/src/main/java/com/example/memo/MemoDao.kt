package com.example.memo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// Deklarasi query untuk data access object pada interface
@Dao
interface MemoDao {
    @Query("SELECT * FROM memo_table ORDER BY title ASC")
    fun getAlphabetizedWords(): LiveData<List<Memo>>

    @Insert
    fun insert(memo: Memo)

    @Query("DELETE FROM memo_table")
    fun deleteAll()
}