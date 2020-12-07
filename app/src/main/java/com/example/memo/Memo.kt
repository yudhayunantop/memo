package com.example.memo

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//deklarasi objek dan dataBase yang memanfaatkan room
@Entity(tableName = "memo_table")
data class Memo(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "title") var titleMemo: String,
        @ColumnInfo(name = "desc_memo") var descMemo: String?
)
