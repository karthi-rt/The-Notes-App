package com.rt.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rt.notesapp.model.Note

@Dao
interface NoteDao {
    /* (onConflict = OnConflictStrategy.REPLACE)
     There is a conflict, If same primary is already exist in the table, then the old data will be replaced
     with the new data.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    // suspend function indicates, this function is called from Coroutine.
    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    //custom query is used by @Query annotation
    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    // :query is the keyword is needs to be searched in the database.
    // keyword matches either title or description then store the result in livedata containing list of note entities.
    @Query("SELECT * FROM notes WHERE noteTitle LIKE :query OR noteDescription LIKE :query")
    // ? -> means it can be null. No specific criteria are provided
    fun searchNote(query: String?): LiveData<List<Note>>
}