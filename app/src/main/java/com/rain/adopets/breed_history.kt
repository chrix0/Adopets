package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class breed_history : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed_history)
        val actionbar = supportActionBar
        actionbar!!.title = "History"
        actionbar.setDisplayHomeAsUpEnabled(true)
        var data : MutableList<classBreedHistory> = singletonData.breedHistory
        var r = findViewById<RecyclerView>(R.id.recycleView)
        var MyAdapter = recycler_breed_history_adapter(this,data){
        }
        r.layoutManager = LinearLayoutManager(this)
        r.adapter = MyAdapter
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}