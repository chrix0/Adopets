package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_adopt_form.*

class adopt_form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_form)
        val actionbar = supportActionBar
        actionbar!!.title = "Form"
        actionbar.setDisplayHomeAsUpEnabled(true)
        var pilihan = arrayOf("Home","Rent","Apartment","Warehouse","Others")
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,pilihan)
        tipeRumah.adapter = adapter
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun Submit(view: android.view.View) {

        var intent = Intent(this, adopt_track::class.java)
        startActivity(intent)
    }
}