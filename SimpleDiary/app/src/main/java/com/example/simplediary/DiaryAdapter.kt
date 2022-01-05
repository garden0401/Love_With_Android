package com.example.simplediary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DiaryAdapter(val diaryItemClick: (Diary) -> Unit, val diaryItemLongClick: (Diary) -> Unit)
    : RecyclerView.Adapter<DiaryAdapter.ViewHolder>() {
    private var diarys: List<Diary> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diary, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return diarys.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(diarys[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val titleTv = itemView.findViewById<TextView>(R.id.item_tv_title)
        private val contentTv = itemView.findViewById<TextView>(R.id.item_tv_content)
        private val initialTv = itemView.findViewById<TextView>(R.id.item_tv_initial)

        fun bind(diary: Diary) {
            titleTv.text = diary.title
            contentTv.text = diary.content
            initialTv.text = diary.initial.toString()

            itemView.setOnClickListener {
                diaryItemClick(diary)
            }

            itemView.setOnLongClickListener {
                diaryItemLongClick(diary)
                true
            }
        }
    }

    fun setDiarys(diarys: List<Diary>) {
        this.diarys = diarys
        notifyDataSetChanged()
    }

}