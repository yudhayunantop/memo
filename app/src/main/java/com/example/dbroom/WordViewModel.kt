package com.example.dbroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel (application: Application) : AndroidViewModel(application){
    private val repository: WordRepository
    val allWords : LiveData<List<Word>>

    // deklarasi dao dan repository pada viewModel
    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    //menambahkan insert pada viewModel
    fun insert(word:Word) = viewModelScope.launch {
        repository.insert(word)
    }

    //menambahkan delete pada viewModel
    fun deleteALL() = viewModelScope.launch {
        repository.deleteALL()
    }
}