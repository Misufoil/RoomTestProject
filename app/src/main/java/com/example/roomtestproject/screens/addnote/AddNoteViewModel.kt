package com.example.roomtestproject.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomtestproject.REPOSITORY
import com.example.roomtestproject.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel: ViewModel() {

    fun insert(noteModel: NoteModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }
}