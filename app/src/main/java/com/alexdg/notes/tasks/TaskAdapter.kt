package com.alexdg.notes.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexdg.notes.R
import com.alexdg.notes.foundations.BaseRecyclerAdapter
import com.alexdg.notes.models.Task
import com.alexdg.notes.views.TaskView

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
) : BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }

    class ViewHolder(view: View) : BaseViewHolder<Task>(view) {

        override fun onBind(task: Task) {
            (view as TaskView).initView(task)
        }
    }
}