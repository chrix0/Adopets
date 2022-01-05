package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_breed_form.*

class breed_form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_form)
        val actionbar = supportActionBar
        actionbar!!.title = "Form"
        actionbar.setDisplayHomeAsUpEnabled(true)
        submit.setOnClickListener(){
            if(check()){
                var intent = Intent(this, breed_track::class.java)
                startActivity(intent)
            }
        }

    }
    private fun check() : Boolean{
        var done : Boolean = true
        if(namaPenerima.text.toString() == ""){
            Toast.makeText(this, "Name must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(alamatPenerima.text.toString() == ""){
            Toast.makeText(this,"Address must be filled",Toast.LENGTH_SHORT).show()
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
        if(namaHewan.text.toString() == ""){
            Toast.makeText(this, "Pet name must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(jenisHewan.text.toString() == ""){
            Toast.makeText(this, "Pet type must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(umurHewan.text.toString() == ""){
            Toast.makeText(this, "Pet age must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(!male.isChecked && !female.isChecked){
            Toast.makeText(this, "Pet gender must be selected", Toast.LENGTH_SHORT).show()
            return false
        }
        if(alasanHewan.text.toString() == ""){
            Toast.makeText(this, "Reason must be filled", Toast.LENGTH_SHORT).show()
            return false
        }
        if(!correct.isChecked){
            Toast.makeText(this, "Please check the box", Toast.LENGTH_SHORT).show()
            return false
        }

        return done
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}