package com.alexdg.notes.tasks


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexdg.notes.R
import com.alexdg.notes.models.Task
import com.alexdg.notes.models.Todo
import kotlinx.android.synthetic.main.fragment_tasks_list.*

class TasksListFragment : Fragment() {

    lateinit var touchActionDelegate: TouchActionDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            if (it is TouchActionDelegate) {
                touchActionDelegate = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = TaskAdapter(
            mutableListOf(
                Task(
                    "Testing One!", mutableListOf(
                        Todo("Test one", true),
                        Todo("Test two")
                    )
                ),
                Task("Testing Two!")
            )
            , touchActionDelegate
        )

        recyclerView.adapter = adapter

    }

    companion object {

        fun newInstance(): TasksListFragment = TasksListFragment()

    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}
