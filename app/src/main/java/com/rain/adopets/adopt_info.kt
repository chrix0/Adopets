package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_adopt_info.*
import kotlinx.android.synthetic.main.activity_register.view.*

class adopt_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adopt_info)
        val intentData = intent

        //Membuat action bar secara manual dengan tombol up
        val actionbar = supportActionBar
        actionbar!!.title = "Info"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val data : classAdopt = intentData.getParcelableExtra<classAdopt>(SHOW_ADOPT_INFO) as classAdopt
        Picasso.get().load(data.pic).into(photo)
        name.text = data.nama
        type.text = data.tipe
        gender.text = data.jenKel
        location.text = data.lokasi
        desc.text = data.desk

        adopt.setOnClickListener(){
            var intent = Intent(this, adopt_form::class.java)
            startActivity(intent)
        }
    }
    //Back ketika menekan tombol up
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}