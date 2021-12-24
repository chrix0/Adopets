package com.rain.adopets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class recycler_shoptransaction_adapter(data : List<classTransaction>) : RecyclerView.Adapter<recycler_shoptransaction_adapter.myHolder>(){

    private var myData = data
    class myHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var recycler = itemView.findViewById<RecyclerView>(R.id.produkTampil)
        var count = itemView.findViewById<TextView>(R.id.jumlahItem)
        var details = itemView.findViewById<Button>(R.id.details)
        var cancel = itemView.findViewById<Button>(R.id.batal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycler_shoptransaction_adapter.myHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_tracker,parent,false)
        return recycler_shoptransaction_adapter.myHolder(inflate)
    }

    override fun onBindViewHolder(holder: recycler_shoptransaction_adapter.myHolder, position: Int) {

    }

    override fun getItemCount(): Int = myData.size
}