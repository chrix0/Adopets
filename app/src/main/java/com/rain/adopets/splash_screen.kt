package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("Deprecation")
class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //PLAN : GIVE MAIN + LAUNCHER
        Handler().postDelayed(Runnable{
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}