package com.example.android_base_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timesClicked = 0
        val btnClickMe = findViewById<Button>(R.id.myButton)
        val textView = findViewById<TextView>(R.id.textView)
        btnClickMe.setOnClickListener{
            timesClicked++

            textView.text = timesClicked.toString()

            Toast.makeText(this, "Hey I'm a toast!", Toast.LENGTH_LONG).show()
        }
    }
}