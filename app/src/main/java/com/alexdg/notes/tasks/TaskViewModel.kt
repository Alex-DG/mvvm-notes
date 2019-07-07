package com.alexdg.notes.tasks

import androidx.lifecycle.ViewModel
import com.alexdg.notes.models.Task
import com.alexdg.notes.models.Todo

class TaskViewModel : ViewModel() {

    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Testing 1!", mutableListOf(
                Todo("Test A!", true),
                Todo("Test B!")
            )
        ),
        Task("Testing 2!"),
        Task(
            "Testing 3!", mutableListOf(
                Todo("Test A!"),
                Todo("Test B!")
            )
        )

    )
}