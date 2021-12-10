package com.rain.adopets

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.text.DecimalFormat
import java.text.NumberFormat

class recycler_products_adapter(data : List<classProduk>) : RecyclerView.Adapter<recycler_products_adapter.myHolder>() {

    private var myData = data
    class myHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nama: TextView = itemView.findViewById<TextView>(R.id.title)
        val harga: TextView = itemView.findViewById<TextView>(R.id.price)
        val gambar: ImageView = itemView.findViewById<ImageView>(R.id.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val inflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_products,parent,false)
        return myHolder(inflate)
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.nama.setText(myData.get(position).namaProduk)
        holder.harga.setText("Rp." + formatHarga(myData.get(position).hargaProduk))
        Picasso.get().load(myData[position].urlGambarProduk).into(holder.gambar)
    }

    fun formatHarga(harga : Int) : String{
        var formatter : DecimalFormat = NumberFormat.getInstance() as DecimalFormat
        formatter.applyPattern("#,###")
        return formatter.format(harga)
    }

    override fun getItemCount(): Int = myData.size
}