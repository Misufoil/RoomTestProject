package com.example.roomtestproject.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtestproject.R
import com.example.roomtestproject.databinding.ItemLayoutBinding
import com.example.roomtestproject.model.NoteModel
import com.example.roomtestproject.screens.start.StartFragment

class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val binding = ItemLayoutBinding.bind(view)
        fun bind(note: NoteModel) {
            binding.apply {
                itemTitle.text = note.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNote[position])
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
        super.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: NoteViewHolder) {
        holder.itemView.setOnClickListener(null)
    }


}