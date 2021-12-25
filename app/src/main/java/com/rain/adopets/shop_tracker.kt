package com.rain.adopets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_shop_product_list.*
import kotlinx.android.synthetic.main.activity_shop_tracker.*

class shop_tracker : AppCompatActivity() {
    //Alert dialog details
    //Ignore back button
    //Alert dialog cancel
    //Multi fab library

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_tracker)

        var adapter = recycler_shoptransaction_adapter(this, singletonData.accList[singletonData.currentAccId].transactionHistory)
        listHistory.layoutManager = LinearLayoutManager(this)
        listHistory.adapter = adapter

        returnShop.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}