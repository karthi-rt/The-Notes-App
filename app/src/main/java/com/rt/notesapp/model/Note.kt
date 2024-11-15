package com.rt.notesapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    // it will be difficult to transfer this type of data, in such cases we will go for parcelization
    val id: Int,
    val noteTitle: String,
    val noteDescription: String
): Parcelable

