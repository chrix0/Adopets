package com.rain.adopets

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class recycler_wiki_adapter(
    val context : Context, data : MutableList<classWiki>,
    private val clickListener: (classWiki) -> Unit):
    RecyclerView.Adapter<recycler_wiki_adapter.MyHolder>() {
    private var myData = data
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var photo = itemView.findViewById<ImageView>(R.id.photo)
        var name = itemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_wiki,parent,false)
        return recycler_wiki_adapter.MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Picasso.get().load(myData[position].pic).into(holder.photo)
        holder.name.setText(myData.get(position).nama)
        holder.itemView.setOnClickListener(){
            clickListener(myData[position])
        }
    }

    override fun getItemCount(): Int = myData.size
}