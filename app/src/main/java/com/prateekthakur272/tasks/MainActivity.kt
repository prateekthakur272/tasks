package com.prateekthakur272.tasks

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val introImages:ImageView = findViewById(R.id.intro_images)
        val imageArray:Array<Int> = arrayOf(R.drawable.cat,R.drawable.crocodile,R.drawable.elephant,R.drawable.monkey,R.drawable.sea_horse)
        var image = 0
        val handler = Handler()
        Thread {
            while (true) {
                introImages.setImageResource(imageArray[image++ % imageArray.size])
                Thread.sleep(500)
            }
        }.start()
        handler.postDelayed({finish()},4000)
    }
}