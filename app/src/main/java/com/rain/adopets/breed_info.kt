package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_adopt_info.*
import kotlinx.android.synthetic.main.activity_adopt_info.desc
import kotlinx.android.synthetic.main.activity_adopt_info.gender
import kotlinx.android.synthetic.main.activity_adopt_info.location
import kotlinx.android.synthetic.main.activity_adopt_info.name
import kotlinx.android.synthetic.main.activity_adopt_info.photo
import kotlinx.android.synthetic.main.activity_adopt_info.type
import kotlinx.android.synthetic.main.activity_breed_info.*
import kotlinx.android.synthetic.main.activity_breed_info.apply
import kotlinx.android.synthetic.main.recycler_breed.*
import kotlin.apply

class breed_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_info)
        val intentData = intent
        val actionbar = supportActionBar
        actionbar!!.title = "Info"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val data : classBreed = intentData.getParcelableExtra<classBreed>(SHOW_BREED_INFO) as classBreed
        Picasso.get().load(data.pic).into(photo)
        name.text = data.nama
        tipe.text = data.tipe
        gender.text = data.jenKel
        location.text = data.lokasi
        pricex.text = data.price
        desc.text = data.desk

        health.text = data.health

        apply.setOnClickListener(){
            var intent = Intent(this, breed_form::class.java)
            startActivity(intent)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}