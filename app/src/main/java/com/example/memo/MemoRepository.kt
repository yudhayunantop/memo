package com.example.memo

import android.os.AsyncTask
import androidx.lifecycle.LiveData

class MemoRepository(private val memoDao: MemoDao){

    //deklarasi LiveData pada repository
    val allMemos: LiveData<List<Memo>> = memoDao.getAlphabetizedWords()

    // menambahkan insert dari wordDao ke Repository
    fun insert(memo: Memo){
        val insertMemoAsyncTask = InsertMemoAsyncTask(memoDao).execute(memo)
    }

    //menambahkan delete dari wordDao ke Repository
    fun deleteALL(){
        val deleteAllmemoAsyncTask = DeleteAllmemoAsyncTask(memoDao).execute()
    }

    //    Menerapkan Courutine pada query
    companion object {
        private class InsertMemoAsyncTask(memoDao: MemoDao) : AsyncTask<Memo, Unit, Unit>() {
            val memoDao = memoDao
            override fun doInBackground(vararg p0: Memo?) {
                memoDao.insert(p0[0]!!)
            }
        }
        private class DeleteAllmemoAsyncTask(memoDao: MemoDao) : AsyncTask<Unit, Unit, Unit>() {
            val memoDao = memoDao
            override fun doInBackground(vararg p0: Unit?) {
                memoDao.deleteAll()
            }
        }
    }
}