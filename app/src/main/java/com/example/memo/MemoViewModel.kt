package com.example.memo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MemoViewModel (application: Application) : AndroidViewModel(application){
    private val repository: MemoRepository
    val allWords : LiveData<List<Memo>>

    // deklarasi dao dan repository pada viewModel
    init {
        val wordsDao = MemoRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = MemoRepository(wordsDao)
        allWords = repository.allMemos
    }

    //menambahkan insert pada viewModel
    fun insert(memo:Memo) = viewModelScope.launch {
        repository.insert(memo)
    }

    //menambahkan delete pada viewModel
    fun deleteALL() = viewModelScope.launch {
        repository.deleteALL()
    }
}