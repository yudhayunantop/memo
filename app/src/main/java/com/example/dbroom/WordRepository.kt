package com.example.dbroom

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao){

    //deklarasi LiveData pada repository
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    // menambahkan insert dari wordDao ke Repository
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }

    //menambahkan delete dari wordDao ke Repository
    suspend fun deleteALL(){
        wordDao.deleteAll()
    }
}