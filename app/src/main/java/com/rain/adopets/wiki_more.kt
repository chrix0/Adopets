package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class wiki_more : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wiki_more)
        var key = intent
        val actionbar = supportActionBar
        actionbar!!.title = "Info"
        actionbar.setDisplayHomeAsUpEnabled(true)
        var tipe = key.getStringExtra(SHOW_WIKI_MORE).toString()
        var title = findViewById<TextView>(R.id.title)
        if(tipe == "info"){
            title.text = "SPECIES INFORMATION"
        }
        else{
            title.text = "TIPS & TRICK"
        }
        var dataAwal : MutableList<classWiki> = singletonData.wikiSpecies
        var dataAkhir = filter(dataAwal,tipe)
        var r = findViewById<RecyclerView>(R.id.recycleView)
        var MyAdapter = recycler_wiki_adapter(this,dataAkhir){
            var intent = Intent(this, wiki_info::class.java)
            intent.putExtra(SHOW_WIKI_INFO,it)
            startActivity(intent)
        }
        r.layoutManager = GridLayoutManager(this, 2)
        r.adapter = MyAdapter
    }
    private fun filter(data : MutableList<classWiki>, tipe : String) : MutableList<classWiki>{
        var newList : MutableList<classWiki> = mutableListOf()
        for(i : classWiki in data){
            if(i.tipe.contains(tipe)){
                newList.add(i)
            }
        }
        return newList
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}