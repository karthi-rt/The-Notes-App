package com.rt.notesapp.repository

import androidx.room.Query
import com.rt.notesapp.database.NoteDatabase
import com.rt.notesapp.model.Note

class NoteRepository(
    private val db: NoteDatabase
) {
   // Call all 5 function insert, update, delete, ... all the methods in respective function

    // suspend makes sure all the operations running in the background thread
    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

}