package com.alexdg.notes.tasks

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alexdg.notes.R
import com.alexdg.notes.foundations.BaseRecyclerAdapter
import com.alexdg.notes.models.Note
import com.alexdg.notes.navigation.NavigationActivity
import com.alexdg.notes.notes.NotesListFragment
import com.alexdg.notes.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionDelegate: NotesListFragment.TouchActionDelegate
) : BaseRecyclerAdapter<Note>(noteList) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == TYPE_ADD_BUTTON) {
            AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false))
        } else {
            NoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false))
        }

    class NoteViewHolder(view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)
        }
    }

    inner class AddButtonViewHolder(view: View) : BaseRecyclerAdapter.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)

            view.setOnClickListener {
                touchActionDelegate.onAddButtonClicked(NavigationActivity.FRAGMENT_VALUE_NOTE)
            }
        }

    }
}