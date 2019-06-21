package com.alexdg.notes.views

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import com.alexdg.notes.models.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note) {
        descriptionView.text = note.description
    }

}
