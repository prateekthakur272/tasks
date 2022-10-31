package com.prateekthakur272.tasks

import android.content.Intent
import android.net.Uri
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
            openUrl("https://prateekthakur272.github.io")
        }
    }
    private fun openUrl(url:String):Unit{
        val uriUrl: Uri = Uri.parse(url)
        val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
        startActivity(launchBrowser)
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}