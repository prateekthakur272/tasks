package com.prateekthakur272.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"

        val githubButton:Button = findViewById(R.id.github_button)

        githubButton.setOnClickListener {
            startActivity(Intent(this,ContactMeActivity::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}