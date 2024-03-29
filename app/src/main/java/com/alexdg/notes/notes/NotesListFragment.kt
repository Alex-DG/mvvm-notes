package com.alexdg.notes.notes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexdg.notes.R
import com.alexdg.notes.tasks.NoteAdapter
import kotlinx.android.synthetic.main.fragment_notes_list.*

class NotesListFragment : Fragment() {

    lateinit var viewModel: NoteViewModal
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
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViewModel()

        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = NoteAdapter(
            viewModel.getFakeData(), touchActionDelegate
        )

        recyclerView.adapter = adapter

    }

    private fun bindViewModel() {
        viewModel = ViewModelProviders.of(this).get(NoteViewModal::class.java)
    }

    companion object {
        fun newInstance(): NotesListFragment = NotesListFragment()
    }

    interface TouchActionDelegate {
        fun onAddButtonClicked(value: String)
    }

}
