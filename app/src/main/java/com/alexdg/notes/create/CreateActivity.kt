package com.alexdg.notes.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexdg.notes.R
import com.alexdg.notes.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            textView.text = when (this) {
                NavigationActivity.FRAGMENT_VALUE_TASK -> "TASK"
                NavigationActivity.FRAGMENT_VALUE_NOTE -> "NOTE"
                else -> "ERROR"
            }
        }

    }
}
