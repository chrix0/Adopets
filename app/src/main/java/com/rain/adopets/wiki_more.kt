package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_wiki_more.*

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
        recycleViewUpdate(dataAkhir)
        var dataAkhir2 = search(dataAkhir)
        filterAtoZ(dataAkhir2)


    }
    private fun search(list : MutableList<classWiki>) : MutableList<classWiki>{
        var newList = mutableListOf<classWiki>()
        var search = findViewById<EditText>(R.id.search)
        search.setOnEditorActionListener { textView, i, keyEvent ->
            if(i == EditorInfo.IME_ACTION_DONE){
                newList.clear()
                newList.addAll(filterNama(search.text.toString(),list))
                recycleViewUpdate(newList)
            }
            return@setOnEditorActionListener true
        }
        return newList
    }
    private fun filterAtoZ(list : MutableList<classWiki>){
        var filter = findViewById<ImageButton>(R.id.button_filter)
        filter.setOnClickListener() {
            list.sortBy { it.nama }
            list.reverse()
            recycleViewUpdate(list)
        }
    }
    private fun filterNama(searchText : String, data : MutableList<classWiki>) : MutableList<classWiki>{
        var newList : MutableList<classWiki> = mutableListOf()
        var text = searchText.trim().lowercase()
        if (text.equals("")){
            newList.addAll(data)
        }
        else{
            for(i : classWiki in data){
                if(i.nama.lowercase().contains(text)){
                    newList.add(i)
                }
            }
        }

        return newList
    }
    private fun recycleViewUpdate(data : MutableList<classWiki>){
        var r = findViewById<RecyclerView>(R.id.recycleView)
        var MyAdapter = recycler_wiki_adapter(this,data){
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