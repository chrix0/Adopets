package com.rain.adopets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_shop_info_produk.*

class shop_infoProduk : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_info_produk)

        val intentData = intent

        //Membuat action bar secara manual dengan tombol up
        val actionbar = supportActionBar
        actionbar!!.title = intentData.getStringExtra(CHANGE_TITLE)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val produk : classProduk = intentData.getParcelableExtra<classProduk>(SHOW_PRODUCT_INFO) as classProduk

        Picasso.get().load(produk.urlGambarProduk).into(productImg)
        name.text = produk.namaProduk
        price.text = "Rp." + singletonData.formatHarga(produk.hargaProduk)
        infoText.text = produk.description

    }
    //Back ketika menekan tombol up
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}