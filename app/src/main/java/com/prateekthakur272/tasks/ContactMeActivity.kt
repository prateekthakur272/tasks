package com.prateekthakur272.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ContactMeActivity : AppCompatActivity() {

    private lateinit var contactMeWebView :WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_me)

        supportActionBar?.title = "Contact me"

        contactMeWebView = findViewById(R.id.contact_me)
        contactMeWebView.loadUrl("https://prateekthakur272.github.io")
    }
    override fun onBackPressed() {
        if (contactMeWebView.canGoBack())
            contactMeWebView.goBack()
        else
            finish()
    }
}