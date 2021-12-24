package com.rain.adopets

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class recycler_adopt_adapter(val context : Context, data : MutableList<classAdopt>,
private val clickListener: (classAdopt) -> Unit) : RecyclerView.Adapter<recycler_adopt_adapter.MyHolder>(){
    private var myData = data
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var petPhoto = itemView.findViewById<ImageView>(R.id.photo)
        var petName = itemView.findViewById<TextView>(R.id.name)
        var petGender = itemView.findViewById<TextView>(R.id.gender)
        var petLocation = itemView.findViewById<TextView>(R.id.location)
        var adopt = itemView.findViewById<Button>(R.id.adopt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_adopt,parent,false)
        return MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Picasso.get().load(myData[position].pic).into(holder.petPhoto)
        holder.petName.setText(myData.get(position).nama)
        holder.petGender.setText(myData.get(position).jenKel)
        holder.petLocation.setText(myData.get(position).lokasi)

        holder.adopt.setOnClickListener(){
            clickListener(myData[position])
        }
    }

    override fun getItemCount(): Int = myData.size
}