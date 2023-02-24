package com.github.yourusername.bootcamp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GreetingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting)

        val textView = findViewById<TextView>(R.id.greetingMessage)
        val text = intent.getStringExtra("text")
        textView.text = text
    }
}