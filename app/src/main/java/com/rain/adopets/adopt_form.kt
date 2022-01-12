package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adopt_form.*
import kotlinx.android.synthetic.main.activity_adopt_form.alamatPenerima
import kotlinx.android.synthetic.main.activity_adopt_form.kodePosPenerima
import kotlinx.android.synthetic.main.activity_adopt_form.kotaPenerima
import kotlinx.android.synthetic.main.activity_adopt_form.namaPenerima
import kotlinx.android.synthetic.main.activity_adopt_form.nomorTeleponPenerima
import kotlinx.android.synthetic.main.activity_adopt_form.provinsiPenerima
import kotlinx.android.synthetic.main.activity_breed_form.*

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
    private fun check() : Boolean{
        var done : Boolean = true
        if(namaPenerima.text.toString() == ""){
            Toast.makeText(this, "Name must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(alamatPenerima.text.toString() == ""){
            Toast.makeText(this,"Address must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(kotaPenerima.text.toString() == ""){
            Toast.makeText(this, "City must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(provinsiPenerima.text.toString() == ""){
            Toast.makeText(this, "Province must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(kodePosPenerima.text.toString() == ""){
            Toast.makeText(this, "Postal code must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(nomorTeleponPenerima.text.toString() == ""){
            Toast.makeText(this, "Phone number must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(totalPet.text.toString() == ""){
            Toast.makeText(this, "Please fill the empty form", Toast.LENGTH_SHORT).show()
            return false
        }
        if(locationNewPet.text.toString() == ""){
            Toast.makeText(this, "Please fill the empty form", Toast.LENGTH_SHORT).show()
            return false
        }
        if(!ready.isChecked){
            Toast.makeText(this, "Please check the box", Toast.LENGTH_SHORT).show()
            return false
        }

        return done
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    fun Submit(view: android.view.View) {
        if(check()){
            var intent = Intent(this, adopt_track::class.java)
            startActivity(intent)
        }

    }
}