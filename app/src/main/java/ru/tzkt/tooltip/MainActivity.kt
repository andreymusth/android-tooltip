package ru.tzkt.tooltip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Tooltip(testTextView, "вы все говно").show()

        testTextView.setOnClickListener {
            Tooltip(testTextView, "вы все говно").show()
        }
    }
}
