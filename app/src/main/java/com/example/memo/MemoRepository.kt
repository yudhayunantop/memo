package com.example.memo

import androidx.lifecycle.LiveData

class MemoRepository(private val memoDao: MemoDao){

    //deklarasi LiveData pada repository
    val allMemos: LiveData<List<Memo>> = memoDao.getAlphabetizedWords()

    // menambahkan insert dari wordDao ke Repository
    suspend fun insert(memo: Memo){
        memoDao.insert(memo)
    }

    //menambahkan delete dari wordDao ke Repository
    suspend fun deleteALL(){
        memoDao.deleteAll()
    }
}