package com.example.dbroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//deklarasi objek dan dataBase yang memanfaatkan room
@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey
    @ColumnInfo(name = "word")
    val word: String
)
