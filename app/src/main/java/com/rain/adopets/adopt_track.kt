package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_adopt_form.*
import kotlinx.android.synthetic.main.activity_adopt_track.*

class adopt_track : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_track)
        val actionbar = supportActionBar
        actionbar!!.title = "Track"
        actionbar.setDisplayHomeAsUpEnabled(true)
        home.setOnClickListener(){
            var intent = Intent(this, Adopt_Main_Frag::class.java)
            startActivity(intent)
        }
    }
}