package com.example.memo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider

class NewMemoActivity : AppCompatActivity() {

    private lateinit var editTitle: EditText
    private lateinit var editDescView: EditText
    private lateinit var memoViewModel: MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        // deklarasi editView dan button save
        editDescView = findViewById(R.id.edit_desc)
        editTitle = findViewById(R.id.edit_title)
        val button = findViewById<Button>(R.id.button_save)
        // deklarasi viewModel
        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)

        //tombol save ditekan
        button.setOnClickListener{
            val title = editTitle.text.toString()
            val word = editDescView.text.toString()

            //memasukkan data ke objek
            var memo = Memo(title, word)
            memo.titleMemo = title
            memo.descMemo = word

            //masukkan data ke db
            memoViewModel.insert(memo)

            //start activity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

            Toast.makeText(applicationContext,
                    "Data Tersimpan", Toast.LENGTH_LONG).show()
        }
    }

}