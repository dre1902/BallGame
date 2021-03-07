package com.example.ballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.b_lvl1).setOnClickListener { startLevel() }
    }

    private fun startLevel() {
        val intent = Intent(this, Level::class.java)
        startActivity(intent)
    }
}