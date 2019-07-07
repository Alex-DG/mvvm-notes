package com.alexdg.notes.notes

import androidx.lifecycle.ViewModel
import com.alexdg.notes.models.Note

class NoteViewModal : ViewModel() {

    fun getFakeData() : MutableList<Note> = mutableListOf(
        Note("Note 1"),
        Note("Note 2")
    )
}