package com.example.memo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemoListAdapter internal constructor(context: Context) : RecyclerView.Adapter<MemoListAdapter.MemoViewHolder>() {

    //deklarasi inflater, listener, object word
    private val inflater: LayoutInflater= LayoutInflater.from(context)
    private var memos = emptyList<Memo>()
    var clickListener : OnClickListener? = null

    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val memoTitleView: TextView = itemView.findViewById(R.id.textTitle)
        val memoDescView: TextView = itemView.findViewById(R.id.textDesc)
    }

    //select recyclerview_item.xml sebagai item_row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item,parent, false)
        return MemoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int){
        //nampilkan di list
        val current = memos[position]
        holder.memoTitleView.text = current.titleMemo
        holder.memoDescView.text = current.descMemo
        holder.memoTitleView.setOnClickListener({itemView -> clickListener?.onClick(position)})
    }

    //setData pada recyclerView
    internal fun setMemos(memos: List<Memo>) {
        this.memos = memos
        notifyDataSetChanged()
    }
    override fun getItemCount() = memos.size

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