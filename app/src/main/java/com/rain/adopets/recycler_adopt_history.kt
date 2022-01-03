package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycler_adopt_history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_adopt_history)
        val actionbar = supportActionBar
        actionbar!!.title = "History"
        actionbar.setDisplayHomeAsUpEnabled(true)
        var data : MutableList<classAdoptHistory> = singletonData.adoptHistory
        var r = findViewById<RecyclerView>(R.id.recycleView)
        var MyAdapter = recycler_adopt_history_adapter(this,data){
        }
        r.layoutManager = LinearLayoutManager(this)
        r.adapter = MyAdapter
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}