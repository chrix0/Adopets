package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_adopt_info.*
import kotlinx.android.synthetic.main.activity_wiki_info.*

class wiki_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wiki_info)
        val intentData = intent
        val actionbar = supportActionBar
        actionbar!!.title = "Info"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val data : classWiki = intentData.getParcelableExtra<classWiki>(SHOW_WIKI_INFO) as classWiki
        nama.text = data.nama
        desk.text = data.desk
        desk2.text = data.desk2
        Picasso.get().load(data.pic).into(pic)
        Picasso.get().load(data.pic2).into(pic2)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}