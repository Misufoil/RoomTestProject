package com.example.roomtestproject.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.roomtestproject.REPOSITORY
import com.example.roomtestproject.db.NoteDatabase
import com.example.roomtestproject.db.repository.NoteRealization
import com.example.roomtestproject.model.NoteModel

class StartViewModel(application: Application): AndroidViewModel(application) {
    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }


}