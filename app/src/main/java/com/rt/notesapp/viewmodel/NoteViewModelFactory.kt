package com.rt.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rt.notesapp.repository.NoteRepository

// ViewModelFactory -> It is a class that instantiates and returns viewmodel
class NoteViewModelFactory(val app: Application,
    private val noteRepository: NoteRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app, noteRepository) as T
    }


}