package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class splash_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //PLAN : GIVE MAIN + LAUNCHER
        var intent = Intent(this, MainActivity::class.java)
        Thread.sleep(3000)
        startActivity(intent)
    }
}