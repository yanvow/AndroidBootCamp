package com.github.yourusername.bootcamp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainGoButton = findViewById<Button>(R.id.mainGoButton)
        val textView = findViewById<TextView>(R.id.mainName)

        mainGoButton.setOnClickListener {
            val intent = Intent(this, GreetingActivity::class.java)
            intent.putExtra("text", textView.text.toString())
            startActivity(intent)
        }
    }
}