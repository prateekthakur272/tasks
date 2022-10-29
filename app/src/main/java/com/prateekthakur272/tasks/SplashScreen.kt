package com.prateekthakur272.tasks

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.Menu
import android.widget.ImageView

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        val introImages: ImageView = findViewById(R.id.intro_images)
        val imageArray:Array<Int> = arrayOf(R.drawable.cat,R.drawable.crocodile,R.drawable.elephant,R.drawable.monkey,R.drawable.sea_horse,R.drawable.octopus,R.drawable.puppy,R.drawable.turtle,R.drawable.kuala)
        var image = 0
        val handler = Handler()
        Thread {
            while (true) {
                introImages.setImageResource(imageArray[image++ % imageArray.size])
                SystemClock.sleep(250)
            }
        }.start()
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()},2400)
    }
}