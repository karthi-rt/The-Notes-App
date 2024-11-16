package com.rt.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rt.notesapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase: RoomDatabase() { // This is the main access point of the database.

    // abstract function is basically no body in it.
    abstract fun getNoteDao(): NoteDao

    // whatever present inside companion object is static and can be access anywhere in the code using it name.
    companion object {
        // Volatile annotation ensures that changes made by one thread are immediately visible to other threads.
        @Volatile
        // instance variable holds the singleton object of the NoteDatabase or null.
        private var instance: NoteDatabase? = null
        // LOCK object which is used to synchronize the database creation process.
        private val LOCK = Any()


        // only one thread is executed at a time in this block.
        /* invoke operator is used for simplicity when creating an instance and also double check in LOCK in pattern
        is implement to ensure that thread safety during database creation process.*/
        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK) {
            instance ?:
            createDatabase(context).also{
                instance = it
            }
        }

        // It is responsible for creating NoteDatabase instance using databaseBuilder
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_db"  // Database Name
            ).build()
    }
}