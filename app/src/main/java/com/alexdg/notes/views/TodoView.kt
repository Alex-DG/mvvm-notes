package com.alexdg.notes.views

import android.content.Context
import android.graphics.Paint
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.alexdg.notes.models.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

class TodoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(todo: Todo) {

        descriptionView.text = todo.description
        completeCheckBox!!.isChecked = todo.isComplete

        if (todo.isComplete) {
            createStrikeThrough()
        }

        setUpCheckStateListener()
    }

    private fun setUpCheckStateListener() {
        completeCheckBox!!.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    private fun createStrikeThrough() {
        descriptionView.apply {
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        descriptionView.apply {
            paintFlags = 0
        }
    }
}
