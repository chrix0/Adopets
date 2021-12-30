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

class recycler_breed_adapter(val context : Context, data : MutableList<classBreed>,
                             private val clickListener: (classBreed) -> Unit)
    : RecyclerView.Adapter<recycler_breed_adapter.MyHolder>() {
    private var myData = data
    class MyHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tampil = itemView.findViewById<RecyclerView>(R.id.breedRecycleView)
        var petPhoto = itemView.findViewById<ImageView>(R.id.photo)
        var petName = itemView.findViewById<TextView>(R.id.name)
        var petGender = itemView.findViewById<TextView>(R.id.gender)
        var petLocation = itemView.findViewById<TextView>(R.id.location)
        var breed = itemView.findViewById<Button>(R.id.apply)
        var petPrice = itemView.findViewById<TextView>(R.id.price)
        var health = itemView.findViewById<TextView>(R.id.health)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recycler_breed_adapter.MyHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_breed,parent,false)
        return recycler_breed_adapter.MyHolder(inflate)
    }

    override fun onBindViewHolder(holder: recycler_breed_adapter.MyHolder, position: Int) {
        Picasso.get().load(myData[position].pic).into(holder.petPhoto)
        holder.petName.setText(myData.get(position).nama)
        holder.petGender.setText(myData.get(position).jenKel)
        holder.petLocation.setText(myData.get(position).lokasi)
        holder.petPrice.setText(myData.get(position).price)
        holder.breed.setOnClickListener(){
            clickListener(myData[position])
        }
    }

    override fun getItemCount(): Int = myData.size
}