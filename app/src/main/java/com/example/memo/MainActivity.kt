package com.example.memo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var memoViewModel: MemoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //deklarasi adapter dan recyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = MemoListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // deklarasi viewModel
        memoViewModel = ViewModelProvider(this).get(MemoViewModel::class.java)

        // panggil data dari db
        memoViewModel.allWords.observe(this, Observer { memo ->
            memo?.let {
                adapter.setMemos(it)
                adapter.setOnClickListener {
                    val current = memo[it]
                    Toast.makeText(this, current.titleMemo , Toast.LENGTH_SHORT).show()
                    // intent ke detail
                }
            }

        })

        //menambahkan event pada fab
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity,NewMemoActivity::class.java)
            startActivity(intent)

        }

        //menambahkan hapus pada button
        val del = findViewById<Button>(R.id.btnhapus)
        del.setOnClickListener{
            memoViewModel.deleteALL()
            Toast.makeText(applicationContext,
                R.string.Hapus, Toast.LENGTH_LONG).show()

        }

    }
}