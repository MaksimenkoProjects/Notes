package com.example.notes.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.model.AppNote

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    private var mListNotes = emptyList<AppNote>()
    override fun onViewAttachedToWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(mListNotes.get(holder.adapterPosition))
        }
    }

    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.textNote.text = mListNotes.get(position).text
        holder.nameNote.text = mListNotes.get(position).name
    }

    override fun getItemCount() = mListNotes.size


    class MainHolder(view: View): RecyclerView.ViewHolder(view){
        val nameNote: TextView = view.findViewById(R.id.itemNoteName)
        val textNote: TextView = view.findViewById(R.id.itemNoteText)
    }

    fun setList(list: List<AppNote>){
        mListNotes = list
        notifyDataSetChanged()
    }
}