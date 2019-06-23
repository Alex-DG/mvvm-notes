package com.alexdg.notes.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexdg.notes.R
import com.alexdg.notes.foundations.BaseRecyclerAdapter
import com.alexdg.notes.models.Task
import com.alexdg.notes.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*

class TaskAdapter(
    taskList: MutableList<Task> = mutableListOf()
) : BaseRecyclerAdapter<Task>(taskList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_INFO) {
            TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
        } else {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        }


    class TaskViewHolder(view: View) : BaseViewHolder<Task>(view) {

        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }


    class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_task)
        }

    }
}