package com.rain.adopets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class recycler_adopt_history_adapter
    (val context : Context, data : MutableList<classAdoptHistory>,
private val clickListener: (classAdoptHistory) -> Unit)
: RecyclerView.Adapter<recycler_adopt_history_adapter.MyHolder>() {
    private var myData = data
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var pic = itemView.findViewById<ImageView>(R.id.photo)
        var name = itemView.findViewById<TextView>(R.id.name)
        var jenkel = itemView.findViewById<TextView>(R.id.gender)
        var lokasi = itemView.findViewById<TextView>(R.id.location)
        var date = itemView.findViewById<TextView>(R.id.datex)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): recycler_adopt_history_adapter.MyHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_adopt_history,parent,false)
        return recycler_adopt_history_adapter.MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: recycler_adopt_history_adapter.MyHolder, position: Int) {
        Picasso.get().load(myData[position].pic).into(holder.pic)
        holder.name.setText(myData.get(position).nama)
        holder.jenkel.setText(myData.get(position).jenKel)
        holder.lokasi.setText(myData.get(position).lokasi)
        holder.date.setText(myData.get(position).date)
    }

    override fun getItemCount(): Int = myData.size

}