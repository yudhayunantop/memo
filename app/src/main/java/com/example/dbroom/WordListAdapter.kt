package com.example.dbroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordListAdapter internal constructor(context: Context) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    //deklarasi inflater, listener, object word
    private val inflater: LayoutInflater= LayoutInflater.from(context)
    private var words = emptyList<Word>()
    var clickListener : OnClickListener? = null

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val wordItemView: TextView = itemView.findViewById(R.id.textView)
    }

    //select recyclerview_item.xml sebagai item_row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent, false)
        return WordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int){
        val current = words[position]
        holder.wordItemView.text = current.word
        holder.wordItemView.setOnClickListener({itemView -> clickListener?.onClick(position)})
    }

    //setData pada recyclerView
    internal fun setWords(words: List<Word>) {
        this.words = words
        notifyDataSetChanged()
    }
    override fun getItemCount() = words.size

    // menambahkan setOnclickListener pada recyclerView
    fun setOnClickListener(listener: (Int) -> Unit){
        this.clickListener = object: OnClickListener {
            override fun onClick(position: Int) {
                listener(position)
            }
        }
    }


    interface OnClickListener{
        fun onClick(position: Int)
    }
}